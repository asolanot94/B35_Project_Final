package nttdata.grupouno.com.ClientBootCoin.services;

import com.ctc.wstx.dtd.ModelNode;
import nttdata.grupouno.com.ClientBootCoin.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {
    Mono<Client> created(Client client);

    Mono<Long> findByDocumentNumberAndDocumentType(String documentNumber, String documentType);
}
