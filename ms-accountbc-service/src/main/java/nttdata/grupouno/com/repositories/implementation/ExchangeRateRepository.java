package nttdata.grupouno.com.repositories.implementation;

import nttdata.grupouno.com.config.ObjectMapperUtils;
import nttdata.grupouno.com.model.ExchangeRate;
import nttdata.grupouno.com.repositories.IExchangeRateRepository;
import nttdata.grupouno.com.repositories.redis.ReactiveRedisComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static nttdata.grupouno.com.config.ObjectMapperUtils.BOOK_KEY;

@Repository
public class ExchangeRateRepository implements IExchangeRateRepository {
    @Autowired
    private ReactiveRedisComponent reactiveRedisComponent;

    @Override
    public Mono<ExchangeRate> save(ExchangeRate model) {
        return reactiveRedisComponent.set(BOOK_KEY, model.getId(), model).map(b -> model);
    }

    @Override
    public Mono<ExchangeRate> get(String key) {
        return reactiveRedisComponent.get(BOOK_KEY, key).flatMap(d -> Mono.just(ObjectMapperUtils.objectMapper(d, ExchangeRate.class)));
    }

    @Override
    public Flux<ExchangeRate> getAll() {
        return reactiveRedisComponent.get(BOOK_KEY).map(b -> ObjectMapperUtils.objectMapper(b, ExchangeRate.class))
                .collectList().flatMapMany(Flux::fromIterable);
    }

    @Override
    public Mono<Long> delete(String id) {
        return reactiveRedisComponent.remove(BOOK_KEY,id);
    }
}
