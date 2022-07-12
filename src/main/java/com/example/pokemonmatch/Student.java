package com.example.pokemonmatch;

public class Student {

    private String id;
    private String name;
    private String firstName;

    public Student (){

    }
    public Student(String id, String name, String firstName){
        this.id = id;
        this.name = name;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
}
