package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BuzzFiveDivisibilityRuleTest {

   @Test
    void canReturnBuzzNumberDivisibleByFive() {

        // Given
       var numberRule = new NumberRule();
       var buzzFiveDivisibilityRule = new BuzzFiveDivisibilityRule();
       buzzFiveDivisibilityRule.registerNextRule(numberRule);

        //When
        var ruleResult = buzzFiveDivisibilityRule.runOn(10);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("10");
    }

    @Test
    void canReturnNumberWithAnyOtherNumber() {

        // Given
        var numberRule = new NumberRule();
        var buzzFiveDivisibilityRule = new BuzzFiveDivisibilityRule();
        buzzFiveDivisibilityRule.registerNextRule(numberRule);

        //When
        var ruleResult = buzzFiveDivisibilityRule.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Buzz.toString());

    }
}