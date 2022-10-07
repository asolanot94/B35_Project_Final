package nttdata.grupouno.com.services.impl;

import nttdata.grupouno.com.model.ExchangeRate;
import nttdata.grupouno.com.repositories.IExchangeRateRepository;
import nttdata.grupouno.com.services.IExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ExchangeRateService implements IExchangeRateService {
    @Autowired
    private IExchangeRateRepository exchangeRateRepository;
    @Override
    public Mono<ExchangeRate> create(ExchangeRate model) {
        return exchangeRateRepository.save(model);
    }

    @Override
    public Flux<ExchangeRate> getAll() {
        return exchangeRateRepository.getAll();
    }

    @Override
    public Mono<ExchangeRate> getOne(String id) {
        return exchangeRateRepository.get(id);
    }

    @Override
    public Mono<Long> deleteById(String id) {
        return exchangeRateRepository.delete(id);
    }
}
