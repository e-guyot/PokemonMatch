package com.example.pokemonmatch.entity;

public class Pokemon {

    private String name;
    private String url;
    private String sprites;

    public Pokemon(){

    }

    public Pokemon(String name, String url, String sprites){
        this.name = name;
        this.url = url;
        this.sprites = sprites;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSprites(String sprites) {
        this.sprites = sprites;
    }

    public String getSprites() {
        return sprites;
    }
}
