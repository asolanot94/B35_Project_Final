package nttdata.grupouno.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "accountBootcoin")
public class Account {
    private String id;
    private Client cliente;
    private Double amount;
    private String state;
    private String startDate;
    private String endDate;

}
