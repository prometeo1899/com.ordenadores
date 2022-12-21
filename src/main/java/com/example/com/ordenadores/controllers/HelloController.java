package com.example.com.ordenadores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")

    public String saludo (){
        return "Hello REINA te quiero :*";
    }
}
