package com.ironhack.helloweb.service;

import com.ironhack.helloweb.model.Coffee;
import com.ironhack.helloweb.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;
    public List<Coffee> findAll() {
        log.info("Find all coffees");
        return coffeeRepository.findAll();
    }

    public Coffee findById(Long id) {
        log.info("Find coffee by id: {}", id);
        return coffeeRepository.findById(id) .orElseThrow();
    }

    private List<Coffee> findAllByOrigin(String origin) {
        log.info("Find coffee by origin: {}", origin);
        return coffeeRepository.findAllByOriginIgnoreCase(origin);
    }

    private List<Coffee> findAllByOriginAndName(String origin, String name) {
        log.info("Find coffee by origin: {} and name:{}" , origin, name);
        return coffeeRepository.findAllByOriginIgnoreCaseAndNameIgnoreCase(origin, name);
    }

    public List<Coffee> filterByOriginAndName(String origin, String name) {
        if (name == null) {
            return findAllByOrigin(origin);
        }
        else {
            return findAllByOriginAndName(origin, name);
        }

}

   // public List<Coffee> filterByOriginAndName(String origin, Optional<String> name) {
   //     if (name.isEmpty()) {
   //         return findAllByOrigin(origin);
   //     }
   //     else {
   //         return findAllByOriginAndName(origin, name.get());
   //     }
  //  }
    }

