package nttdata.grupouno.com.msmarketBCservice.service.impl;

import nttdata.grupouno.com.msmarketBCservice.model.RequestBC;
import nttdata.grupouno.com.msmarketBCservice.repositories.IPaymentMethodRepository;
import nttdata.grupouno.com.msmarketBCservice.repositories.RequestBCRepository;
import nttdata.grupouno.com.msmarketBCservice.service.IRequestBCService;
import nttdata.grupouno.com.msmarketBCservice.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Service
public class RequestBCServiceImpl implements IRequestBCService {
    @Autowired
    private RequestBCRepository requestBCRepository;
    @Autowired
    private IPaymentMethodRepository paymentMethodRepository;
    @Override
    public Mono<RequestBC> createdRequestBC(RequestBC requestBC) {
        requestBC.setId(UUID.randomUUID().toString());
        requestBC.setRequestingDate(Util.dateTimeToString(new Date()));
        return paymentMethodRepository.get(requestBC.getPaymentMethod().getId()).flatMap(paymentMethod -> {
            requestBC.setPaymentMethod(paymentMethod);
            return requestBCRepository.save(requestBC);
        });
    }

    @Override
    public Flux<RequestBC> findAll() {
        return requestBCRepository.findAll();
    }

    @Override
    public Mono<RequestBC> findById(String id) {
        return requestBCRepository.findById(id);
    }

    @Override
    public Mono<RequestBC> updateRequestBC(RequestBC requestBC) {
        return requestBCRepository.save(requestBC);
    }

    @Override
    public Mono<RequestBC> aceptRequestBC(String id,String client) {
        return requestBCRepository.findById(id).flatMap(a -> {
            if (a.getIdRequestingClient().equals(client) || a.getState().equals("A")){
                return Mono.empty();
            }
            a.setState("A");
            a.setAcceptingDate(Util.dateTimeToString(new Date()));
            a.setAcceptingDate(client);
            return requestBCRepository.save(a);
        }).switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> delete(String id) {
        return requestBCRepository.deleteById(id);
    }
}
