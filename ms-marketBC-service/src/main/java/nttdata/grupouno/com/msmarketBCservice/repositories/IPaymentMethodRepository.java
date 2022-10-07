package nttdata.grupouno.com.repositories;

import nttdata.grupouno.com.model.ExchangeRate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IExchangeRateRepository {
    Mono<ExchangeRate> save(ExchangeRate model);
    Mono<ExchangeRate> get(String key);
    Flux<ExchangeRate> getAll();
    Mono<Long> delete(String id);
}
