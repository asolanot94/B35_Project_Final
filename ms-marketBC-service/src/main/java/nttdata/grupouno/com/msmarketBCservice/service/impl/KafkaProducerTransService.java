package nttdata.grupouno.com.msmarketBCservice.service.impl;

import nttdata.grupouno.com.msmarketBCservice.model.RequestBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerTransService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerTransService.class);

    private final KafkaTemplate<String, RequestBC> kafkaTemplate;

    public KafkaProducerTransService(@Qualifier("kafkaAccountTemplate") KafkaTemplate<String, RequestBC> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RequestBC requestBC) {
        LOGGER.info("Producing message {}", requestBC);
        this.kafkaTemplate.send("transaction-topic", requestBC);
    }
}
