package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BodyInfoRepository repository) {
        BodyInfo b1 = new BodyInfo("Jack",  1111);
        //b1.setId(1);
        //BodyInfo b2 = new BodyInfo("Ali ", 2222);
        //b1.setId(2);
        BodyInfo b3 = new BodyInfo("Jane", 3333);
        //b3.setId(3);
        BodyInfo b4 = new BodyInfo("James",  4444);
        //b4.setId(4);
        return (args) -> {
            // save a couple of customers
            repository.save(b1);
            repository.save(b3);
            repository.save(b4);

            // fetch all customers

            log.info("BodyInfos found with findAll():");
            log.info("-------------------------------");
            for (BodyInfo b : repository.findAll()) {
                log.info(b.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            /*
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });
            */
            // fetch customers by last name
            log.info("BodyInfo found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByName("Kim").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}