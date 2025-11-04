package syssy2025.possuclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PossuclientApplication {

	@Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("https://ticket-guru-bitti-possut-ticketguru-bittipossut.2.rahtiapp.fi").defaultHeaders(headers -> headers.setBasicAuth("user", "password")).build();
    }

	public static void main(String[] args) {
		SpringApplication.run(PossuclientApplication.class, args);


	}

}
