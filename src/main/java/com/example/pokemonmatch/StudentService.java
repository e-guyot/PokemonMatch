package com.example.pokemonmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("StudentService")
public class StudentService {


    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("S1", "Dupont", "Charles"),
            new Student("S2", "Marceaux", "Léa")
    ));

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(String id) {
        Student s = students.stream()
                .filter(student -> id.equals(student.getId()))
                .findAny()
                .orElse(null);
        return s;
    }


    public void addStudent(Student student) {
        students.add(student);
    }


    public void updateStudent(String id, Student student) {

        for (Student s : students) {
            if (id.equals(s.getId())) {
                s.setFirstName(student.getFirstName());
                s.setName(student.getName());
            }
        }

    }

    public void deleteStudent(String id) {
        students.remove(id);
    }
}
