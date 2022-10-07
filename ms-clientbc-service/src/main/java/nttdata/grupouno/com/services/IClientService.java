package nttdata.grupouno.com.services;

import nttdata.grupouno.com.model.Client;
import reactor.core.publisher.Mono;

public interface IClientService {
    Mono<Client> created(Client client);

    Mono<Long> findByDocumentNumberAndDocumentType(String documentNumber, String documentType);
}
