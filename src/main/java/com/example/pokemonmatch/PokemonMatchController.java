package com.example.pokemonmatch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class PokemonMatchController {

    @RequestMapping("/home")
    public ModelAndView  home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("name", "name");
        return modelAndView;
    }

    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon(){
        final String uri = "https://pokeapi.co/api/v2/pokemon";

        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(uri, PokemonResult.class);

        return result.getResults();

    }
}
