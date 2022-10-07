package nttdata.grupouno.com.mstransactionservice.service;

import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {
    Mono<Transaction> createdTransaction(Transaction transaction);
    Flux<Transaction> findAll();
    Mono<Transaction> findById(String id);
}
