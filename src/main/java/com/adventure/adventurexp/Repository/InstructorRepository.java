package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <Instructor, Long> {
}
