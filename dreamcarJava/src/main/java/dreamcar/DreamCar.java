package dreamcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DreamCar {

    public static void main(String[] args) {
        SpringApplication.run(DreamCar.class, args);
    }

}
