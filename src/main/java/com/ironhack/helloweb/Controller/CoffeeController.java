package com.ironhack.helloweb.Controller;

import com.ironhack.helloweb.model.Coffee;
import com.ironhack.helloweb.repository.CoffeeRepository;
import com.ironhack.helloweb.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Coffee")
@RequiredArgsConstructor
public class CoffeeController {

    final CoffeeRepository coffeeRepository;
    private final CoffeeService coffeeService;

    @GetMapping
    public List <Coffee> getAllCoffee ()  {
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Coffee getCoffeeById (@PathVariable("id") Long id) {
        return coffeeService.findById(id) ;
    }

    @GetMapping("/filters")
    public List <Coffee> getCoffeeByOrigin (@RequestParam String origin,
                                            @RequestParam (required = false) String name) {
        return coffeeService.filterByOriginAndName(origin,name);
    }


    //@GetMapping("/filters")
    //public List <Coffee> getCoffeeByFiltered (@RequestParam String origin,
    //                                        @RequestParam Optional <String>name) {
    //    return coffeeService.filterByOriginAndName(origin,name);
    // }
}
