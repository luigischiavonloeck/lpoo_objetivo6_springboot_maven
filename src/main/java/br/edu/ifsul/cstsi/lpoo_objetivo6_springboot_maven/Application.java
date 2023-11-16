package br.edu.ifsul.cstsi.lpoo_objetivo6_springboot_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        HomeController.main(null);
    }

}
