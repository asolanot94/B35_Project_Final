package nttdata.grupouno.com.mstransactionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transactionBootcoin")
public class Transaction {
    @Id
    private String id;
    private Double amount;
    private PaymentMethod paymentMethod;

}
