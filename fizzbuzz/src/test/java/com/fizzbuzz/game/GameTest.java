package com.fizzbuzz.game;

import com.fizzbuzz.model.Person;
import com.fizzbuzz.model.Student;
import com.fizzbuzz.rules.CompositeRules;
import com.fizzbuzz.service.SoundService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

class GameTest {

    @Test
    void canPlayFizzBuzzGame() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(1,5);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = asList(
                "Student #1 -> 1 -> 1",
                "Student #2 -> 2 -> 2",
                "Student #3 -> 3 -> Fizz",
                "Student #4 -> 4 -> 4",
                "Student #5 -> 5 -> Buzz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .hasSize(5)
                .containsAll(expected);

    }

    @Test
    void canSayFizzBuzzWhenNumberIsThreeDivisible() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(3,3);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 3 -> Fizz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canSayFizzBuzzWhenNumberContainsThree() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(13,13);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 13 -> Fizz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canSayBuzzBuzzWhenNumberIsFiveDivisible() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(5,5);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 5 -> Buzz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canSayBuzzBuzzWhenNumberContainsFive() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(52,52);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 52 -> Buzz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canSayFizzBuzzBuzzWhenNumberFiveThreeDivisible() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(15,15);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 15 -> FizzBuzz"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canSayNumberWhenRulesDoesNotApply() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(7,7);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = singletonList(
                "Student #1 -> 7 -> 7"
        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .containsAll(expected);

    }

    @Test
    void canReturnEmplyListWhenNumberRangeIsEmpty() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(Collections.emptyList());
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        Assertions.assertThat(gameResult)
                .isNotNull()
                .isEmpty();
    }

    @Test
    void canReturnEmptyListWhenStudentListIsEmpty() {

        //Given
        var students = new ArrayList<Person>();
        var numberRange = new NumberRange(1,100);

        //When
        //Then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Game(numberRange,students));
    }


    @Test
    void canSayFizzBuzzWhenNumbeListContains15() {

        //Given
        var students = getStudents();
        var numberRange = new NumberRange(11,15);
        var fizzBuzzGame = new Game(numberRange,students);


        //When
        var gameResult = fizzBuzzGame.play();


        //Then
        var expected = asList(
                "Student #1 -> 11 -> 11",
                "Student #2 -> 12 -> Fizz",
                "Student #3 -> 13 -> Fizz",
                "Student #4 -> 14 -> 14",
                "Student #5 -> 15 -> FizzBuzz"

        );

        Assertions.assertThat(gameResult)
                .isNotNull()
                .hasSize(5)
                .containsAll(expected);

    }


    public List<Person> getStudents() {
        var rules = new CompositeRules();
        var soundService = new SoundService(rules);

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