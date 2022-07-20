package com.example.pokemonmatch.controller;


import com.example.pokemonmatch.entity.Pokemon;
import com.example.pokemonmatch.entity.Student;
import com.example.pokemonmatch.repository.StudentRepository;
import com.example.pokemonmatch.service.PokemonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentService;
    @Autowired
    private PokemonApiService pokemonApiService;

    @GetMapping("/add")
    public ModelAndView addStudents(){
        ModelAndView modelAndView = new ModelAndView("studentForm");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addStudent(@ModelAttribute Student student) {
        //studentService.addStudent(student);
        if (student == null){
            return addStudents();
        }
        ModelAndView modelAndView = new ModelAndView("fetichePokemon");

        modelAndView.addObject("pokemon", student);
        var hashCode = student.getFirstName().hashCode()+student.getName().hashCode();
        List<Pokemon> listPokemons = pokemonApiService.getPokemons();

        for (var pokemon : listPokemons){
            if (hashCode == pokemon.hashCode()){
                modelAndView.addObject("pokemon", student);
            }
        }

        return modelAndView;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return studentService.getStudentById(id);
    }



    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
