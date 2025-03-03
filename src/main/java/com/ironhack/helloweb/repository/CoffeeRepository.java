package com.ironhack.helloweb.repository;

import com.ironhack.helloweb.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findAllByOrigin (String origin);


    List<Coffee> findAllByOriginIgnoreCaseAndNameIgnoreCase(String origin, String name);

    List<Coffee> findAllByOriginIgnoreCase(String origin);
}
