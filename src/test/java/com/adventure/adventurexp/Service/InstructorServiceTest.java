package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.InstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

    @Mock
    private InstructorRepository instructorRepository;

    private InstructorService instructorService;

    private long id;

    private Instructor instructor;

    @BeforeEach
    void setUp() {
        instructorService = new InstructorService(instructorRepository);
        id = 10L;
        instructor = new Instructor("Geri", "Veri");
    }

    @Test
    void canGetAllInstructors() {
        instructorService.getAllInstructors();
        verify(instructorRepository).findAll();
    }

    @Test
    void canGetInstructorById() {
        instructorService.getInstructorById(id);
        verify(instructorRepository).findById(id);
    }

    @Test
    void canCreateInstructor() {
        instructorService.createInstructor(instructor);
        ArgumentCaptor<Instructor> instructorArgumentCaptor = ArgumentCaptor.forClass(Instructor.class);
        verify(instructorRepository).save(instructorArgumentCaptor.capture());
        Instructor capturedInstructor = instructorArgumentCaptor.getValue();
        assertThat(capturedInstructor).isEqualTo(instructor);
    }

    @Test
    void canDeleteInstructor() {
        instructorService.deleteInstructor(id);
        verify(instructorRepository).deleteById(id);
    }

    @Test
    void canupdateInstructor() {
        //given - precondition or setup
        instructor.setFirstName("Tibor");
        instructor.setLastName("Hun");
        Mockito.when(instructorRepository.findById(id)).thenReturn(Optional.ofNullable(instructor));
        Mockito.when(instructorRepository.save(instructor)).thenReturn(instructor);

        //when -  action or the behaviour that we are going test
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);

        //then - verify the output
        assertThat(updatedInstructor.getFirstName()).isEqualTo("Tibor");
        assertThat(updatedInstructor.getLastName()).isEqualTo("Hun");
    }

    @Test
    void canUpdateActivityReturnNull() {
        //when -  action or the behaviour that we are going test
        Instructor updatedInstructor = instructorService.updateInstructor(id,instructor);

        //then - verify the output
        assertThat(updatedInstructor).isNull();
    }
}