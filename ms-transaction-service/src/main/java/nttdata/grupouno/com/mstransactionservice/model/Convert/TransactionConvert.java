package nttdata.grupouno.com.mstransactionservice.model.Convert;

import nttdata.grupouno.com.mstransactionservice.model.RequestBC;
import nttdata.grupouno.com.mstransactionservice.model.Transaction;
import nttdata.grupouno.com.mstransactionservice.util.Util;

import java.util.Date;
import java.util.UUID;

public class TransactionConvert {

    public Transaction convertToTransaction(RequestBC requestBC){
        Transaction transaction = new Transaction();
        transaction.setAmountSoles(requestBC.getAmountSoles());
        transaction.setAmountBootcoin(requestBC.getAmountBootcoin());
        transaction.setPaymentMethod(requestBC.getPaymentMethod());
        transaction.setBuyerCustomer(requestBC.getIdRequestingClient());
        transaction.setSellerCustomer(requestBC.getIdAcceptingClient());
        return transaction;
    }
}
