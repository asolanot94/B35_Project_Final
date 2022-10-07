package nttdata.grupouno.com.services.impl;

import nttdata.grupouno.com.model.Account;
import nttdata.grupouno.com.repositories.AccountRepository;
import nttdata.grupouno.com.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Mono<Account> createdAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Flux<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> findById(String id) {
        return accountRepository.findById(id);
    }
}
