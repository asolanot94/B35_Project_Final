package nttdata.grupouno.com.msmarketBCservice.controller;

import nttdata.grupouno.com.msmarketBCservice.model.RequestBC;
import nttdata.grupouno.com.msmarketBCservice.service.IRequestBCService;
import nttdata.grupouno.com.msmarketBCservice.service.impl.KafkaProducerTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/market/requestBC")
public class RequestBCController {
    @Autowired
    private IRequestBCService requestBCService;

    @Autowired
    private KafkaProducerTransService producerService;

    @PostMapping("/")
    public Mono<ResponseEntity<Map<String, Object>>> createdRequestBC(@Valid @RequestBody Mono<RequestBC> requestBCMono){
        Map<String, Object> response = new HashMap<>();
        return requestBCMono.flatMap(a -> requestBCService.createdRequestBC(a).flatMap(b -> {
            response.put("account", b);
            return Mono.just(ResponseEntity.created(URI.create("/market/requestBC/"))
                    .body(response));
        }));
    }

    @GetMapping("/all")
    public Flux<RequestBC> findAll(){
        return requestBCService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Mono<RequestBC>>> findById(@PathVariable("id") final String id){
        Mono<RequestBC> mono = requestBCService.findById(id);
        return Mono.just(new ResponseEntity<>(mono, mono != null ? HttpStatus.OK : HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/client/{client}")
    public Mono<ResponseEntity<RequestBC>> aceptRequestBC(@PathVariable("id") final String id,
                                                          @PathVariable("client") final String client){
        Mono<RequestBC> mono = requestBCService.aceptRequestBC(id,client).doOnSuccess(requestBC -> {
            producerService.sendMessage(requestBC);
        });
         return mono.map(a -> {
            return ResponseEntity.created(URI.create("/market/requestBC/".concat(a.getId())))
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(a);
        }).defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
