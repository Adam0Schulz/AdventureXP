package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class InstructorController {

    InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    //Return all instructors
    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructors();
    }

    //Create a method that returns a single instructor
    @GetMapping("/instructors/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable("id") Long id){
        Instructor instructor = instructorService.getInstructorById(id);
        return new ResponseEntity<>(instructor, HttpStatus.OK);
    }

    //Create an instructor
    @PostMapping("/instructors")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor){
        Instructor newInstructor = instructorService.createInstructor(instructor);
        return new ResponseEntity<>(newInstructor, HttpStatus.CREATED);
    }

    //Update an instructor
    @PutMapping("/instructors/{id}")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor newInstructor, @PathVariable("id") Long id) {
        return new ResponseEntity<Instructor>(instructorService.updateInstructor(id, newInstructor), HttpStatus.OK);
    }

    //Delete an instructor
    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable("id") Long id){
        instructorService.deleteInstructor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
