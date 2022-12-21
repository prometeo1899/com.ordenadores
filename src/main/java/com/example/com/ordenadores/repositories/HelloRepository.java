package com.example.com.ordenadores.repositories;

import com.example.com.ordenadores.entities.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository <Hello,Long>{



}
