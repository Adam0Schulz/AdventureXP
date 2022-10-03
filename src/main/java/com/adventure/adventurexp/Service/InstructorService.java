package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors() {
        List<Instructor> instructorList = instructorRepository.findAll();
        return instructorList;
    }

    public Instructor getInstructorById(Long id) {
        return instructorRepository.findById(id).get();
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    public Instructor updateInstructor(Long id, Instructor newInstructor) {
        if(instructorRepository.findById(id).isEmpty()) {
            return null;
        }

        return instructorRepository.save(newInstructor);
    }

}
