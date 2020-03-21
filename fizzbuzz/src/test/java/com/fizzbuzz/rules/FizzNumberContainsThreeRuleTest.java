package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FizzNumberContainsThreeRuleTest {

    @Test
    void canReturnFizzNumberContainingThree() {

        // Given
        var numberRule = new NumberRule();
        var fizzNumberContainsThreeRule = new FizzNumberContainsThreeRule();
        fizzNumberContainsThreeRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzNumberContainsThreeRule.runOn(53);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Fizz.toString())
                .isNotEqualTo("53");
    }

    @Test
    void canReturnNumberWithAnyOtherNumber() {

        // Given
        var numberRule = new NumberRule();
        var fizzNumberContainsThreeRule = new FizzNumberContainsThreeRule();
        fizzNumberContainsThreeRule.registerNextRule(numberRule);

        //When
        var ruleResult = fizzNumberContainsThreeRule.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Fizz.toString());

    }
}