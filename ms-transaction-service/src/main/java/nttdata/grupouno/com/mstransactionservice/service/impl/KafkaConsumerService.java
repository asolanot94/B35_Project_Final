package nttdata.grupouno.com.mstransactionservice.service;

import nttdata.grupouno.com.mstransactionservice.model.RequestBC;
import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "transaction-topic", groupId = "group_json", containerFactory = "accountKafkaListenerFactory")
    public void consumeJsonAccount(RequestBC transaction) {
        System.out.println("El cliente acepto la compra: " + transaction);

    }
}
