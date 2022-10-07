package nttdata.grupouno.com.msmarketBCservice.service;


import nttdata.grupouno.com.msmarketBCservice.model.PaymentMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPaymentMethodService {
    Mono<PaymentMethod> create(PaymentMethod model);

    Flux<PaymentMethod> getAll();

    Mono<PaymentMethod> getOne(String id);

    Mono<Long> deleteById(String id);
}
