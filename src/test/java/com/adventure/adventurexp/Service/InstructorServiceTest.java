package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Booking;
import com.adventure.adventurexp.Entity.Instructor;
import com.adventure.adventurexp.Repository.InstructorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void updateInstructor() {
        Instructor updatedInstructor = instructorService.updateInstructor(id,instructor);

        assertThat(updatedInstructor).isNotEqualTo(instructor);
    }
}