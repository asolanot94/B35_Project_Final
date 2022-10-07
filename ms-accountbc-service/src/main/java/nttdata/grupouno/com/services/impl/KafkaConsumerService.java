package nttdata.grupouno.com.services.impl;

import nttdata.grupouno.com.model.Client;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "client-topic", groupId = "group_json", containerFactory = "accountKafkaListenerFactory")
    public void consumeJsonAccount(Client client) {
        System.out.println("Se ha creado el siguiente cliente: " + client);
    }
}
