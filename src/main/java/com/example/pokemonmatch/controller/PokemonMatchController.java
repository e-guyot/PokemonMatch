package com.example.pokemonmatch.controller;

import com.example.pokemonmatch.entity.Student;
import com.example.pokemonmatch.entity.Pokemon;
import com.example.pokemonmatch.entity.PokemonResult;
import com.example.pokemonmatch.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class PokemonMatchController {

    @Autowired
    private PokemonApiService pokemonApiService;

    @GetMapping("/")
    public ModelAndView  home() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/pokemon")
    public ModelAndView  getPokemon(@ModelAttribute Student student) {
        if (student == null){
            return home();
        }
        ModelAndView modelAndView = new ModelAndView("fetichePokemon");

        var hashCode = student.getFirstName().hashCode()+student.getName().hashCode();
        Pattern p = Pattern.compile("["+hashCode+"]");
        List<Pokemon> listPokemons = pokemonApiService.getPokemons();
        System.out.println(listPokemons);
        for (var pokemon : listPokemons){
            Matcher result = p.matcher(String.valueOf(pokemon.hashCode()));
            //if (result.matches())
           // {
                modelAndView.addObject("pokemon", pokemon);
         //  }
        }

        return modelAndView;
    }

    @GetMapping("/pokemon")
    public List<Pokemon> getlPokemon(){
        final String uri = "https://pokeapi.co/api/v2/pokemon";

        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(uri, PokemonResult.class);

        return result.getResults();

    }
}
