package com.fizzbuzz.game;

import com.fizzbuzz.model.Person;

import java.util.List;
import java.util.stream.Collectors;


public class Game {

    private final NumberRange range;
    private final List<Person> students;
    private final RoundRobinIter<Person> iter;

    public Game(final NumberRange range, final List<Person> students) {

        if(range == null || students == null || students.isEmpty())
            throw new IllegalArgumentException("Invalid argument(s) passed");

        this.range = range;
        this.students = students;
        this.iter = new RoundRobinIter<>(this.students);
    }

    public List<String> play(){

        var roundRobinIter = iter.iterator();                               // Iterator to iterate students in round robin fashion

        var saidNumbersAndWords = range.getRange()                          // This will give student a number and ask to say either number, Fizz, Buzz or FizzBuzz
                .stream()                                                   // according to set game rules
                .map(number -> roundRobinIter.next().sayNumber(number))
                .collect(Collectors.toList());

        return saidNumbersAndWords;
    }
}
