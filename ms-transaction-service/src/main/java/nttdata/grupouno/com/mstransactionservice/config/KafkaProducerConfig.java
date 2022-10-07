package nttdata.grupouno.com.mstransactionservice.config;


import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    private final String bootstrapAddress = "localhost:9092";

    @Bean
    public ProducerFactory<String, Transaction> producerFactoryAccount(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
        configProps.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
        configProps.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean(name = "kafkaAccountTemplate")
    public KafkaTemplate<String, Transaction> kafkaAccountTemplate() {
        return new KafkaTemplate<>(producerFactoryAccount());
    }
}
