package com.example.com.ordenadores.controllers;

import com.example.com.ordenadores.entities.Laptop;
import com.example.com.ordenadores.repositories.LaptopRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
public class LaptopController {


    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptoprepository) {
        this.laptopRepository = laptoprepository;
    }

    //Busca todos las laptops en la base de datos
    @GetMapping("/api/prueba")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();

    }

    //Busca una laptop en epecifico dependiendo de la id ingresada
    @GetMapping("/api/prueba/{id}")
    public ResponseEntity<Laptop> findById(@PathVariable Long id) {

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    //Crea una nueva laptop en la base de datos si es que la id es nula.
    @PostMapping("/api/prueba")
    public Laptop create(@RequestBody Laptop laptop) {

        return laptopRepository.save(laptop);
    }

    //Actualiza una laptop en la base de datos usando una id existente.
    @PutMapping("/api/prueba/{id}")
    public Laptop update(@RequestBody Laptop laptop) {

        return laptopRepository.save(laptop);
    }

    @DeleteMapping("/api/prueba/{id}")
    public void deleteById(@PathVariable Long id) {

        laptopRepository.deleteById(id);
    }

    //Borra toda la base de datos.
    @DeleteMapping("/api/prueba")
    public void deleteAll() {

        laptopRepository.deleteAll();


    }


}