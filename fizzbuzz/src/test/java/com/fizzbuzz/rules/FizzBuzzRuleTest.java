package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzBuzzRuleTest {

    @Test
    void canReturnFizzBuzzNumberDivisibleByThreeAndFive() {

        // Given
        var numberRule = new NumberRule();
        var fizzBuzzRule = new FizzBuzzRule();
        fizzBuzzRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzBuzzRule.runOn(15);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString())
                .isNotEqualTo("15");
    }

    @Test
    void canReturnNumberWithAnyOtherNumber() {

        // Given
        var numberRule = new NumberRule();
        var fizzBuzzRule = new FizzBuzzRule();
        fizzBuzzRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzBuzzRule.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString());

    }
}