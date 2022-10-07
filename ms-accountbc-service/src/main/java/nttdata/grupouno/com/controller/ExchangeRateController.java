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
    public Mono<ExchangeRate> addTypeDocument(@RequestBody @Valid ExchangeRate request){
        return rateService.create(request);
    }

    @GetMapping("/all")
    public Flux<ExchangeRate> getAllDocument(){
        return rateService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ExchangeRate> getTypeDocument(@PathVariable String id){
        return rateService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public  Mono<Long> deleteTypeDocument(@PathVariable String id){
        return rateService.deleteById(id);
    }
}
