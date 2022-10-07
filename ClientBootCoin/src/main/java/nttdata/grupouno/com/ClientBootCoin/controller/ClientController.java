package nttdata.grupouno.com.ClientBootCoin.controller;

import nttdata.grupouno.com.ClientBootCoin.model.Client;
import nttdata.grupouno.com.ClientBootCoin.services.impl.ClientService;
import nttdata.grupouno.com.ClientBootCoin.services.impl.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping
    public Mono<Map<String, Object>> createdClient(@RequestBody @Valid Mono<Client> client){
        Map<String, Object> response = new HashMap<>();
        return client.flatMap(a -> {
            return clientService.findByDocumentNumberAndDocumentType(a.getDocumentNumber(),a.getDocumentType())
                    .flatMap(aLong -> {
                        if(aLong.intValue() != 0){
                            response.put("msg","El Cliente ya exite");
                            return Mono.just(response);
                        }
                        Mono<Client>  newClient=  clientService.created(a).doOnSuccess(o -> {
                            kafkaProducerService.sendMessage(o);
                        });
                        return newClient.flatMap(client1 -> {
                                    response.put("msg","El fue creado con exito");
                                    response.put("obj",client1);
                                    return Mono.just(response);
                                });
                    });
        });
    }
}
