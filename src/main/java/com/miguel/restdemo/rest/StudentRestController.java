package com.miguel.restdemo.rest;

import com.miguel.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;
    //define @PostConstruct
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Foo","Bar"));
        theStudents.add(new Student("Tom","Jerry"));
        theStudents.add(new Student("Herp","Derp"));
    }
    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }
}
