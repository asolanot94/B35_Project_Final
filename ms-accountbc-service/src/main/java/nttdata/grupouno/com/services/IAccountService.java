package nttdata.grupouno.com.services;

import nttdata.grupouno.com.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountService {
    Mono<Account> createdAccount(Account account);
    Flux<Account> findAll();
    Mono<Account> findById(String id);
}
