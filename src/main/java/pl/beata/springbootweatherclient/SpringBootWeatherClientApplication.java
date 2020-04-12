package pl.beata.springbootweatherclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootWeatherClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherClientApplication.class, args);
    }

}
