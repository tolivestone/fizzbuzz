package com.fizzbuzz.service;

import com.fizzbuzz.enums.Onomatopoeia;
import com.fizzbuzz.rules.CompositeRules;
import com.fizzbuzz.rules.Rule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoundServiceTest {

    private Rule rules = new CompositeRules();

    @BeforeEach
    public void setup() {

    }

    @Test
    void canGenerateFizzSoundForNumberDivisibleByThree() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(9);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("9");
    }


    @Test
    void canGenerateBuzzSoundForNumberDivisibleByFive() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(10);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("10");
    }

    @Test
    void canGenerateFizzSoundForNumberContainingThree() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(13);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("13");
    }

    @Test
    void canGenerateBuzzSoundForNumberContainingFive() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(52);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("52");
    }

    @Test
    void canGenerateFizzBuzzSoundForNumberDivisibleByBothThreeAndFive() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(15);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString())
                .isNotEqualTo("15");
    }

    @Test
    void canGenerateNumberSoundForNumberWhichDoesNotMeetGameRules() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(7);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("7")
                .isNotEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString());
    }

    @Test
    void canGenerateNumberSoundWithNegativeNumber() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(-1);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("-1")
                .isNotEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString());
    }

    @Test
    void canGenerateNumberSoundWithZero() {

        // Given
        Sound soundService = new SoundService(rules);

        //When
        var word = soundService.generate(0);

        //Then
        Assertions.assertThat(word)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("0")
                .isNotEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString());
    }
}