package com.miguel.restdemo.rest;

import com.miguel.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        theStudents.add(new Student("Jane", "Smith"));
        theStudents.add(new Student("Alice", "Johnson"));
        theStudents.add(new Student("Bob", "Williams"));
        theStudents.add(new Student("Emily", "Brown"));
        theStudents.add(new Student("Michael", "Davis"));
        theStudents.add(new Student("Sarah", "Miller"));
        theStudents.add(new Student("David", "Wilson"));
        theStudents.add(new Student("Emma", "Taylor"));
        theStudents.add(new Student("Daniel", "Anderson"));
    }
    //define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {


        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check if id is out of bound
        if ((studentId >= theStudents.size()) || (studentId<0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

}
