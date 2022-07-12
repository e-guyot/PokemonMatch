package com.example.pokemonmatch;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component("PokemonApiService")
public class PokemonApiService {

    public List<Pokemon> getPokemons(){
        final String uri = "https://pokeapi.co/api/v2/pokemon";

        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(uri, PokemonResult.class);

        return result.getResults();

    }
}
