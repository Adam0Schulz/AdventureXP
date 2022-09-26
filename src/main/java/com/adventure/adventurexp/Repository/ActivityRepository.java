package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Long countById(Long id);
}
