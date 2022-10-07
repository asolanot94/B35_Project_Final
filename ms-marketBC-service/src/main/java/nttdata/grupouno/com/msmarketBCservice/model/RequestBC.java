package nttdata.grupouno.com.msmarketBCservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "requestBootCoin")
public class RequestBC {
    @Id
    private String id;
    private Double amountSoles;
    private Double amountBootcoin;
    private PaymentMethod paymentMethod;
    private String requestingDate;
    private String acceptingDate;
    private String idRequestingClient;
    private String idAcceptingClient;
    private String state;///"S"  /  "A"
}
