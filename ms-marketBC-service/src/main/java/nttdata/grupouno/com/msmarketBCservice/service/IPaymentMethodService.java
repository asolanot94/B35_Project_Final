package nttdata.grupouno.com.services;

import nttdata.grupouno.com.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IExchangeRateService {
    Mono<ExchangeRate> create(ExchangeRate model);

    Flux<ExchangeRate> getAll();

    Mono<ExchangeRate> getOne(String id);

    Mono<Long> deleteById(String id);
}
