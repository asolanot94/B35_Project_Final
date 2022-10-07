package nttdata.grupouno.com.mstransactionservice.repositories;

import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
