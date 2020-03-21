package com.fizzbuzz;

import com.fizzbuzz.game.Game;
import com.fizzbuzz.game.NumberRange;
import com.fizzbuzz.model.Person;
import com.fizzbuzz.model.Student;
import com.fizzbuzz.service.Sound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FizzBuzzApplication implements CommandLineRunner {

    @Autowired
    private Sound soundService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(FizzBuzzApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {

        var students = getStudents();                           // Get the list of students. for this example 5 students
        var numberRange = new NumberRange(1,100);               // Set the number range from 1...100
        var fizzBuzzGame = new Game(numberRange,students);      // Set the Game with given number range and students

        var gameResult = fizzBuzzGame.play();                   // Play game

        gameResult.stream().forEach(System.out::println);       // Print game result
    }

    public List<Person> getStudents() {
        var students = List.of(
                new Student
                        .StudentBuilder(1,"Student #1", soundService)
                        .build(),

                new Student
                        .StudentBuilder(2,"Student #2", soundService)
                        .build(),

                new Student
                        .StudentBuilder(3,"Student #3", soundService)
                        .build(),

                new Student
                        .StudentBuilder(4,"Student #4", soundService)
                        .build(),

                new Student
                        .StudentBuilder(5,"Student #5", soundService)
                        .build()
        );

        return students;
    }
}
