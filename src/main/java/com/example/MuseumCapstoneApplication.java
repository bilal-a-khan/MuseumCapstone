package com.example;

//import com.example.utils.Populator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MuseumCapstoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuseumCapstoneApplication.class, args);

//        ApplicationContext context = SpringApplication.run(MuseumCapstoneApplication.class, args);

//        Populator populator = context.getBean(Populator.class);
//        populator.populate();

    }

}
