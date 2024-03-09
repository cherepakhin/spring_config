package ru.perm.v.springconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigApplication.class, args);

// For demo test:
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("beans.xml");
//        GreeterService greeterService =
//                (GreeterService) context.getBean("selectedGreeterService");
//        System.out.println(greeterService.getHello()); // Hello, vasi!

    }
}
