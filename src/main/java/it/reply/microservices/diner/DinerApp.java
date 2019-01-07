package it.reply.microservices.diner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class DinerApp {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DinerApp.class, args);
    }
}
