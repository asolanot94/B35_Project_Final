package nttdata.grupouno.com.repositories;

import nttdata.grupouno.com.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
}
