package nttdata.grupouno.com.msmarketBCservice.repositories;

import nttdata.grupouno.com.msmarketBCservice.model.PaymentMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPaymentMethodRepository {
    Mono<PaymentMethod> save(PaymentMethod model);
    Mono<PaymentMethod> get(String key);
    Flux<PaymentMethod> getAll();
    Mono<Long> delete(String id);
}
