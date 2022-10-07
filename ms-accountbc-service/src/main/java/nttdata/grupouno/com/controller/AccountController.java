package nttdata.grupouno.com.controller;

import nttdata.grupouno.com.model.Account;
import nttdata.grupouno.com.model.ExchangeRate;
import nttdata.grupouno.com.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/")
    public Mono<Account> addTypeDocument(@RequestBody @Valid Account request){
        return accountService.createdAccount(request);
    }

    @GetMapping("/all")
    public Flux<Account> getAllDocument(){
        return accountService.findAll();
    }
}
