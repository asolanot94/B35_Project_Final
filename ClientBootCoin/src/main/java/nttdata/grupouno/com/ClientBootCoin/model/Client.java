package nttdata.grupouno.com.ClientBootCoin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clientBootcoin")
public class Client {


    @Id
    private String id;
    private String documentNumber;
    private String documentType;
    private Integer cellphone;
    private String email;

}
