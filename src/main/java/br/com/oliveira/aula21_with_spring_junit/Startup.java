package br.com.oliveira.aula21_with_spring_junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // Import do banco

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // Ignora o banco no build do Docker
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }

}