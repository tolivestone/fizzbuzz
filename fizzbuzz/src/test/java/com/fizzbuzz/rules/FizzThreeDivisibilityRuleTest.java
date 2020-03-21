package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzThreeDivisibilityRuleTest {

    @Test
    void canReturnFizzNumberDivisibleByThree() {

        // Given
        var numberRule = new NumberRule();
        var fizzThreeDivisibilityRule = new FizzThreeDivisibilityRule();
        fizzThreeDivisibilityRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzThreeDivisibilityRule.runOn(9);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("9");
    }

    @Test
    void canReturnNumberWithAnyOtherNumber() {

        // Given
        var numberRule = new NumberRule();
        var fizzThreeDivisibilityRule = new FizzThreeDivisibilityRule();
        fizzThreeDivisibilityRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzThreeDivisibilityRule.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Fizz.toString());

    }
}