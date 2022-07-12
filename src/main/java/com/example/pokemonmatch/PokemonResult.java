package com.example.pokemonmatch;

import java.util.List;

public class PokemonResult {

    private int count;
    private String next;
    private String previous;
    private List<Pokemon> results;

    public PokemonResult(){

    }

    public PokemonResult(int count, String next, String previous, List<Pokemon> results){
        this.next = next;
        this.count = count;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
