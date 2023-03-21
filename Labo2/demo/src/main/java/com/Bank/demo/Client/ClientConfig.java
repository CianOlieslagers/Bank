package com.Bank.demo.Client;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner(ClientRepo repo){
        return args ->{
            Client Cian = new Client(
                    "Cian",100);
            Client Stef = new Client(
                    "Stef",200);
    repo.saveAll(
            List.of(Cian,Stef));

        };
    }

}
