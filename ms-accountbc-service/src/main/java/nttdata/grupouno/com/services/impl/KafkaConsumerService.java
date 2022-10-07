package nttdata.grupouno.com.services.impl;

import nttdata.grupouno.com.model.Account;
import nttdata.grupouno.com.model.Client;
import nttdata.grupouno.com.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class KafkaConsumerService {
    @Autowired
    private AccountRepository accountRepository;

    @KafkaListener(topics = "client-topic", groupId = "group_json", containerFactory = "accountKafkaListenerFactory")
    public void consumeJsonAccount(Client client) {
        System.out.println("Se ha creado el siguiente cliente: " + client);
        Account newAccount = new Account(UUID.randomUUID().toString(),client,0.0,"A","2022.10.07",null);
        accountRepository.save(newAccount);
        System.out.println("Se ha creado una nueva cuenta: ");
    }
}
