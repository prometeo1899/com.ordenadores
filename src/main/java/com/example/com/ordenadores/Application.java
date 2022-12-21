package com.example.com.ordenadores;

import com.example.com.ordenadores.entities.Hello;
import com.example.com.ordenadores.entities.Laptop;
import com.example.com.ordenadores.repositories.HelloRepository;
import com.example.com.ordenadores.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        HelloRepository repository = context.getBean(HelloRepository.class);

       // Hello hello1 = new Hello(null, "helloo", "hola");
       // repository.save(hello1);
        //System.out.println(repository.findAll());

        LaptopRepository repositoryL = context.getBean(LaptopRepository.class);
        Laptop laptop1 = new Laptop(null,"hp","negro",250);
        repositoryL.save(laptop1);
        Laptop laptop2 = new Laptop(null,"lenovo","gris",150);
        repositoryL.save(laptop2);
        Laptop laptop3 = new Laptop(null,"dell","negro",210);
        repositoryL.save(laptop3);
        System.out.println(repositoryL.findAll());


    }


}
