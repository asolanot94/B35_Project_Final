package nttdata.grupouno.com.msmarketBCservice.repositories.implementation;

import nttdata.grupouno.com.msmarketBCservice.config.ObjectMapperUtils;
import nttdata.grupouno.com.msmarketBCservice.model.PaymentMethod;
import nttdata.grupouno.com.msmarketBCservice.repositories.IPaymentMethodRepository;
import nttdata.grupouno.com.msmarketBCservice.repositories.redis.ReactiveRedisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static nttdata.grupouno.com.msmarketBCservice.config.ObjectMapperUtils.BOOK_KEY;

@Repository
public class PaymentMethodRepository implements IPaymentMethodRepository {
    @Autowired
    private ReactiveRedisComponent reactiveRedisComponent;

    @Override
    public Mono<PaymentMethod> save(PaymentMethod model) {
        return reactiveRedisComponent.set(BOOK_KEY, model.getId(), model).map(b -> model);
    }

    @Override
    public Mono<PaymentMethod> get(String key) {
        return reactiveRedisComponent.get(BOOK_KEY, key).flatMap(d -> Mono.just(ObjectMapperUtils.objectMapper(d, PaymentMethod.class)));
    }

    @Override
    public Flux<PaymentMethod> getAll() {
        return reactiveRedisComponent.get(BOOK_KEY).map(b -> ObjectMapperUtils.objectMapper(b, PaymentMethod.class))
                .collectList().flatMapMany(Flux::fromIterable);
    }

    @Override
    public Mono<Long> delete(String id) {
        return reactiveRedisComponent.remove(BOOK_KEY,id);
    }
}
