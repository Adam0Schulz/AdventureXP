package com.adventure.adventurexp.Common;

import com.adventure.adventurexp.Entity.*;
import com.adventure.adventurexp.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitialData implements CommandLineRunner {

    ActivityRepository activityRepository;
    CustomerRepository customerRepository;
    InstructorRepository instructorRepository;
    BookingRepository bookingRepository;

    CandyRepository candyRepository;

    public InitialData(ActivityRepository activityRepository, CustomerRepository customerRepository, InstructorRepository instructorRepository, BookingRepository bookingRepository, CandyRepository candyRepository) {
        this.activityRepository = activityRepository;
        this.customerRepository = customerRepository;
        this.instructorRepository = instructorRepository;
        this.bookingRepository = bookingRepository;
        this.candyRepository = candyRepository;
    }

    @Override

    public void run(String... args) throws Exception {
        Candy candy1 = new Candy("Sour sam", 12.50);
        Candy candy2 = new Candy("Choco Corny", 9.0);
        Candy candy3 = new Candy("Coconut Corny", 9.0);
        Candy candy4 = new Candy("Famous Amos", 15.00);
        Candy candy5 = new Candy("Nutty Tony", 6.50);

        candyRepository.save(candy1);
        candyRepository.save(candy2);
        candyRepository.save(candy3);
        candyRepository.save(candy4);
        candyRepository.save(candy5);

        //Create Instructor objects
        Instructor instructor1 = new Instructor("Ricky", "Raceman");
        Instructor instructor2 = new Instructor("Lily", "Big");
        Instructor instructor3 = new Instructor("John", "Mini");
        Instructor instructor4 = new Instructor("Esther", "Shooter");
        Instructor instructor5 = new Instructor("Anne", "Sandy");
        Instructor instructor6 = new Instructor("Thomas", "ranger");

        //Save Instructor objects into database
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);

        //Create Activity objects
        Activity goKart = new Activity("Gokart","In go-karting, the participants drive around a course racing the be the first one across the finish line after 20 laps. Points are given based on placement. The participant with the fastest lap will receive 5 bonus points. Age limit: 16+.", instructor1,"gokart.jpg" );
        Activity sumoWrestling = new Activity("Sumo Wrestling", "The participants will wear an inflatable sumo suit and wrestle each other. The purpose is to push the opponent outside of the wrestling ring. Age limit: 11+.", instructor2, "sumo_wrestling.jpg");
        Activity miniGolf = new Activity("Minigolf", "Golf, but mini. It's played on courses consisting of 24 holes. Players aim is to have the least amount of attempts at the end of the game. Players have a maximum of 7 tries per hole. Age limit: 5+.", instructor3, "minigolf.jpg");
        Activity paintBall = new Activity("Paintball","Two teams will go against each other. The purpose is to shoot the opposing team with paint balls until only members from one team is left. Age limit: 18+.", instructor4, "paintball.jpg");
        Activity beachVolleyball = new Activity("Beach Volleyball", "The participants play in teams of two on a sanded volleyball court with a net dividing them. The objective is to send the ball over the net and to hit the opposite teams sand floor. Each team has a max of three touches before the ball must be send over the net. A set is won by the first team to reach 21 points (15 points in the deciding final set) with a two-point advantage. A match is won by whoever wins two sets. Age limit 8+", instructor5, "beach_volleyball.jpg");
        Activity drivingRangeGolf = new Activity("Driving Range Golf", "The participants will rent a tee and a bucket off balls.  This activity can be used for golfers that want to practice their golf swings, or it can be used as a game where participants can shoot for specific targets on the golf course and compete to see who gets the most points. Age limit: 8+", instructor6, "driving_range_golf.jpg");

        //Save Activity objects into database
        activityRepository.save(goKart);
        activityRepository.save(sumoWrestling);
        activityRepository.save(miniGolf);
        activityRepository.save(paintBall);
        activityRepository.save(beachVolleyball);
        activityRepository.save(drivingRangeGolf);

        //create Customer objects
        Customer customer1 = new Customer("John", "Doe", "ghgh@jhdhj.dk","12345678");
        Customer customer2 = new Customer("soheil", "fattah", "jhjh@dk.dk","199345678");
        Customer customer3 = new Customer("emie", "jensen", "jhjhfd@hgh.dk","76765678");

        //Save Customer objects into database
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        //Create Booking objects
        Booking booking1 = new Booking(goKart, LocalDate.of(2022, 10, 6), LocalTime.of(15,30), LocalTime.of(17,30), 4, customer1);
        Booking booking2 = new Booking(goKart, LocalDate.of(2022, 10, 7), LocalTime.of(13,0), LocalTime.of(15,0), 4, customer1);
        Booking booking3 = new Booking(sumoWrestling, LocalDate.of(2022, 10, 6), LocalTime.of(10,0), LocalTime.of(11,0), 2, customer2);
        Booking booking4 = new Booking(miniGolf, LocalDate.of(2022, 10, 18), LocalTime.of(14,30), LocalTime.of(16,30), 3, customer2);
        Booking booking5 = new Booking(paintBall, LocalDate.of(2022, 10, 20), LocalTime.of(11,20), LocalTime.of(13,20), 6, customer3);
        Booking booking6 = new Booking(paintBall, LocalDate.of(2022, 10, 20), LocalTime.of(15,0), LocalTime.of(18,0), 8, customer1);
        Booking booking7 = new Booking(goKart, LocalDate.of(2022, 10, 8), LocalTime.of(15,30), LocalTime.of(17,30), 4, customer1);
        Booking booking8 = new Booking(goKart, LocalDate.of(2022, 10, 8), LocalTime.of(13,0), LocalTime.of(15,0), 4, customer1);
        Booking booking9 = new Booking(sumoWrestling, LocalDate.of(2022, 10, 16), LocalTime.of(10,0), LocalTime.of(11,0), 2, customer2);
        Booking booking10 = new Booking(miniGolf, LocalDate.of(2022, 10, 5), LocalTime.of(14,30), LocalTime.of(16,30), 3, customer2);
        Booking booking11 = new Booking(paintBall, LocalDate.of(2022, 10, 11), LocalTime.of(11,20), LocalTime.of(13,20), 6, customer3);
        Booking booking12 = new Booking(paintBall, LocalDate.of(2022, 10, 12), LocalTime.of(15,0), LocalTime.of(18,0), 8, customer1);

        //Save Booking objects into database
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);
        bookingRepository.save(booking6);
    }
}