package nttdata.grupouno.com.ClientBootCoin.repositories;

import nttdata.grupouno.com.ClientBootCoin.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IClientRepository extends ReactiveMongoRepository<Client, String> {
    Flux<Client> findByDocumentNumberAndDocumentType(String documentNumber, String documentType);
}
