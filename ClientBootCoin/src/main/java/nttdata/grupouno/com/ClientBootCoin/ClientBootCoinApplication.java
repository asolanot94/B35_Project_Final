package nttdata.grupouno.com.ClientBootCoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ClientBootCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBootCoinApplication.class, args);
	}

}
