package nttdata.grupouno.com.ClientBootCoin.services.impl;

import nttdata.grupouno.com.ClientBootCoin.model.Client;
import nttdata.grupouno.com.ClientBootCoin.repositories.IClientRepository;
import nttdata.grupouno.com.ClientBootCoin.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService implements IClientService {
    @Autowired
    IClientRepository clientRepository;

    @Override
    public Mono<Client> created(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Long> findByDocumentNumberAndDocumentType(String documentNumber, String documentType) {
        return clientRepository.findByDocumentNumberAndDocumentType(documentNumber,documentType).count();
    }
}
