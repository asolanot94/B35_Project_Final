package nttdata.grupouno.com.controller;

import nttdata.grupouno.com.model.ExchangeRate;
import nttdata.grupouno.com.services.IExchangeRateService;
import nttdata.grupouno.com.services.impl.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/account/exchange")
public class ExchangeRateController {
    @Autowired
    private ExchangeRateService rateService;

    @PostMapping("/")
    public Mono<ExchangeRate> addRate(@RequestBody @Valid ExchangeRate request){
        return rateService.create(request);
    }

    @GetMapping("/all")
    public Flux<ExchangeRate> getAll(){
        return rateService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ExchangeRate> getById(@PathVariable String id){
        return rateService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public  Mono<Long> deleteById(@PathVariable String id){
        return rateService.deleteById(id);
    }
}
