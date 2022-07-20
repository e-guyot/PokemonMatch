package com.example.pokemonmatch.service;

import com.example.pokemonmatch.entity.Pokemon;
import com.example.pokemonmatch.entity.PokemonResult;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component("PokemonApiService")
public class PokemonApiService {

    public List<Pokemon> getPokemons(){
        // image sprites
        WebClient webClient = WebClient.create();
        PokemonResult result = webClient.get()
                .uri("https://pokeapi.co/api/v2/pokemon")
                .retrieve()
                .bodyToMono(PokemonResult.class)
                .block();
        System.out.println(result);
        return result.getResults();
    }
}
