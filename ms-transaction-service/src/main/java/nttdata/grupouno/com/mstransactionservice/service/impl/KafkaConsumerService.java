package nttdata.grupouno.com.mstransactionservice.service.impl;

import nttdata.grupouno.com.mstransactionservice.model.Convert.TransactionConvert;
import nttdata.grupouno.com.mstransactionservice.model.RequestBC;
import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import nttdata.grupouno.com.mstransactionservice.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class KafkaConsumerService {
    @Autowired
    private TransactionConvert transactionConvert;

    @KafkaListener(topics = "transaction-topic", groupId = "group_json", containerFactory = "accountKafkaListenerFactory")
    public void consumeJsonAccount(RequestBC request) {
        System.out.println("El cliente acepto la compra: " + request);
        Transaction transaction = new Transaction();
        transaction = transactionConvert.convertToTransaction(request);
        transaction.setId(UUID.randomUUID().toString());
        transaction.setDate(Util.dateTimeToString(new Date()));
        System.out.println("Se genera la transacción: " + transaction);

    }
}
