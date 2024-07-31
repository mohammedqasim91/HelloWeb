package com.ironhack.helloweb.Controller;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
@RequiredArgsConstructor
public class GreetController {

    private final Faker faker ;

    @GetMapping
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/{name}")
    public String greetWithName (@PathVariable String name) {
        return "Hello " + faker.pronouns().subjective()+ " " + name + "!";
    }


}
