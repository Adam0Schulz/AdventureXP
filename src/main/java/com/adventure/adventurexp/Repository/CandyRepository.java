package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Candy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandyRepository extends JpaRepository<Candy, Long> {
}
