package com.example.com.ordenadores.controllers;

import com.example.com.ordenadores.entities.Laptop;
import com.example.com.ordenadores.repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptoprepository) {
        this.laptopRepository = laptoprepository;
    }

    @GetMapping("/api/prueba")
    public List<Laptop> pueba (){
        return laptopRepository.findAll();

    }
    @GetMapping("/api/prueba/{id}")
    public ResponseEntity<Laptop> findById (@PathVariable Long id){

        Optional<Laptop> laptopOpt= laptopRepository.findById(id);
     if (laptopOpt.isPresent())
         return ResponseEntity.ok(laptopOpt.get());
     else
         return ResponseEntity.notFound().build();
    }
    @PostMapping("/api/prueba")
    public Laptop crear(@RequestBody Laptop laptop){
  return laptopRepository.save(laptop);



}
}