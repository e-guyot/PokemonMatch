package com.example.pokemonmatch;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class PokemonMatchController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "name");
        return "index";
    }

    @GetMapping("/pokemon")
    public Object getPokemon(){
        final String uri = "https://pokeapi.co/api/v2/";

        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(uri, Object.class);

        return result;
    }
}
