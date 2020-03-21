package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CompositeRulesTest {

    @Test
    void canReturnBuzzNumberDivisibleByFive() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(10);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("10");
    }

    @Test
    void canReturnBuzzWhenNumberContainsFive() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(25);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("25");
    }

    @Test
    void canReturnFizzNumberDivisibleByThree() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(12);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("12");
    }

    @Test
    void canReturnFizzWhenNumberContainsThree() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(13);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("13");
    }

    @Test
    void canReturnFizzBuzzWhenNumberDivisibleByThreeAndFive() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(15);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString())
                .isNotEqualTo("15");
    }

    @Test
    void canReturnWithOtherNumbers() {

        // Given
        var compositeRules = new CompositeRules();

        //When
        var ruleResult = compositeRules.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString());
    }
}