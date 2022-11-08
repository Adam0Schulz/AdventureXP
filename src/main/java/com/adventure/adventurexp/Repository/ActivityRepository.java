package com.adventure.adventurexp.Repository;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    //find by keyword

    @Query("SELECT a FROM Activity a WHERE a.name LIKE %?1% OR a.description LIKE %?1% OR a.imageName LIKE %?1%")
    List<Activity> findByKeywordActivity(String keyword);
    //getimage


}

