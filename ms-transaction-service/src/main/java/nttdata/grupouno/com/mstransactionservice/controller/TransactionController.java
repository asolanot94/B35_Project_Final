package nttdata.grupouno.com.mstransactionservice.controller;

import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import nttdata.grupouno.com.mstransactionservice.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/")
    public Mono<ResponseEntity<Map<String, Object>>> createdTransaction(@RequestBody Mono<Transaction> model){
        Map<String, Object> response = new HashMap<>();
        return model.flatMap(transaction -> transactionService.createdTransaction(transaction)
                .flatMap(a -> {
                    response.put("msj", "Transacción creada exitosamente");
                    response.put("obj", a);
                    return Mono.just(ResponseEntity.created(URI.create("/market/requestBC/"))
                    .body(response));
        }));
    }

    @GetMapping("/all")
    public Flux<Transaction> findAll(){
        return transactionService.findAll();
    }
}
