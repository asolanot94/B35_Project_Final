package nttdata.grupouno.com.mstransactionservice.service.impl;

import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import nttdata.grupouno.com.mstransactionservice.repositories.TransactionRepository;
import nttdata.grupouno.com.mstransactionservice.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Mono<Transaction> createdTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }
}
