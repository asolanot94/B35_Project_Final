package nttdata.grupouno.com.msmarketBCservice.service.impl;

import nttdata.grupouno.com.msmarketBCservice.model.PaymentMethod;
import nttdata.grupouno.com.msmarketBCservice.repositories.IPaymentMethodRepository;
import nttdata.grupouno.com.msmarketBCservice.service.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PaymentMethodService implements IPaymentMethodService {
    @Autowired
    private IPaymentMethodRepository exchangeRateRepository;
    @Override
    public Mono<PaymentMethod> create(PaymentMethod model) {
        return exchangeRateRepository.save(model);
    }

    @Override
    public Flux<PaymentMethod> getAll() {
        return exchangeRateRepository.getAll();
    }

    @Override
    public Mono<PaymentMethod> getOne(String id) {
        return exchangeRateRepository.get(id);
    }

    @Override
    public Mono<Long> deleteById(String id) {
        return exchangeRateRepository.delete(id);
    }
}
