package nttdata.grupouno.com.msmarketBCservice.service;

import nttdata.grupouno.com.msmarketBCservice.model.RequestBC;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IRequestBCService {
    Mono<RequestBC> createdRequestBC(RequestBC requestBC);
    Flux<RequestBC> findAll();
    Mono<RequestBC> findById(String id);
    Mono<RequestBC> updateRequestBC(RequestBC requestBC);
    Mono<RequestBC> aceptRequestBC(String id,String client);
    Mono<Void> delete(String id);
}
