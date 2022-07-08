package com.example.pokemonmatch;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonMatchController {

    @RequestMapping
    public String PokemonMatch(){
        return "Hello world, pokemon Match";
    }
}
