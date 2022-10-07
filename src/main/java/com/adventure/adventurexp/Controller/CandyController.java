package com.adventure.adventurexp.Controller;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Candy;
import com.adventure.adventurexp.Service.ActivityService;
import com.adventure.adventurexp.Service.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CandyController {

    //Dependencies
    private final CandyService candyService;

    @Autowired
    public CandyController(CandyService candyService) {
        this.candyService = candyService;
    }

    //Return all activities
    @GetMapping("/candy")
    public List<Candy> getAllCandy(){
        return candyService.getAllCandy();
    }

    //Create a method that returns a single activity
    @GetMapping("/candy/{id}")
    public ResponseEntity<Candy> getCandyById(@PathVariable("id") Long id){
        Candy candy = candyService.getCandyById(id);
        return new ResponseEntity<>(candy, HttpStatus.OK);
    }

    //Create a activity
    @PostMapping("/candy")
    public ResponseEntity<Candy> createCandy(@RequestBody Candy candy){
        Candy newCandy = candyService.createCandy(candy);
        return new ResponseEntity<>(newCandy, HttpStatus.CREATED);
    }

    //Update an activity
    @PutMapping("/candy/{id}")
    public ResponseEntity<Candy> updateCandy(@RequestBody Candy newCandy, @PathVariable("id") Long id) {
        return new ResponseEntity<Candy>(candyService.updateCandy(id, newCandy), HttpStatus.OK);
    }

}
