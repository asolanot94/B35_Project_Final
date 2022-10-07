package nttdata.grupouno.com.msmarketBCservice.repositories;

import nttdata.grupouno.com.msmarketBCservice.model.RequestBC;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RequestBCRepository extends ReactiveMongoRepository<RequestBC, String> {
}
