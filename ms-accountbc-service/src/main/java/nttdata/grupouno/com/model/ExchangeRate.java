package nttdata.grupouno.com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRate {
    private String id;
    private Double purchaseQuote;
    private Double saleQuote;
    private String date;
    private String state;
}
