package nttdata.grupouno.com.mstransactionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    @Id
    private String id;
    private String description;
}
