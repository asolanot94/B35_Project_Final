package nttdata.grupouno.com.services.impl;

import nttdata.grupouno.com.model.Account;
import nttdata.grupouno.com.services.IAccountService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService implements IAccountService {
    @Override
    public Mono<Account> createdAccount(Account account) {
        return null;
    }

    @Override
    public Flux<Account> findAll() {
        return null;
    }

    @Override
    public Mono<Account> findById(String id) {
        return null;
    }
}
