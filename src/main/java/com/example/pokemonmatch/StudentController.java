package com.example.pokemonmatch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "studentValid";
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable("id") String id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }
}
