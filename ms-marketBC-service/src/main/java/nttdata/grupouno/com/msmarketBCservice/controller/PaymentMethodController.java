package nttdata.grupouno.com.msmarketBCservice.controller;

import nttdata.grupouno.com.msmarketBCservice.model.PaymentMethod;
import nttdata.grupouno.com.msmarketBCservice.service.IPaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/market/Payment")
public class PaymentMethodController {
    @Autowired
    private IPaymentMethodService paymentMethodService;

    @PostMapping("/")
    public Mono<PaymentMethod> addPaymentMethod(@RequestBody Mono<PaymentMethod> request){
        return request.flatMap(a -> paymentMethodService.create(a));
    }

    @GetMapping("/all")
    public Flux<PaymentMethod> findAll(){
        return paymentMethodService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<PaymentMethod> findById(@PathVariable("id") final String id){
        return paymentMethodService.getOne(id);
    }
}
