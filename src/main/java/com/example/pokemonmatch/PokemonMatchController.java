package com.example.pokemonmatch;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonMatchController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "name");
        return "index";
    }
}
