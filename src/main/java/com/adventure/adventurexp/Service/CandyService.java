package com.adventure.adventurexp.Service;

import com.adventure.adventurexp.Entity.Activity;
import com.adventure.adventurexp.Entity.Candy;
import com.adventure.adventurexp.Repository.ActivityRepository;
import com.adventure.adventurexp.Repository.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandyService {

    // Dependencies
    private final CandyRepository candyRepo;

    @Autowired
    public CandyService(CandyRepository candyRepo) {
        this.candyRepo = candyRepo;
    }

    public List<Candy> getAllCandy() {
        return candyRepo.findAll();
    }

    public Candy getCandyById(Long id) {
        return candyRepo.findById(id).orElse(null);
    }

    public Candy createCandy(Candy candy) {
        return candyRepo.save(candy);
    }


    public Candy updateCandy(Long id, Candy newCandy) {
        if(candyRepo.findById(id).isEmpty()) {
            return null;
        }

        return candyRepo.save(newCandy);
    }
}
