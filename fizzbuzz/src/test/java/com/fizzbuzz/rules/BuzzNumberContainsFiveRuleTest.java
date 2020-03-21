package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BuzzNumberContainsFiveRuleTest {

    @Test
    void canReturnBuzzNumberContainingFive() {

        // Given
        var numberRule = new NumberRule();
        var buzzNumberContainsFiveRule = new BuzzNumberContainsFiveRule();
        buzzNumberContainsFiveRule.registerNextRule(numberRule);

        //When
        var ruleResult = buzzNumberContainsFiveRule.runOn(52);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo(Onomatopoeia.Buzz.toString())
                .isNotEqualTo("52");
    }

    @Test
    void canReturnNumberWithAnyOtherNumber() {

        // Given
        var numberRule = new NumberRule();
        var buzzNumberContainsFiveRule = new BuzzNumberContainsFiveRule();
        buzzNumberContainsFiveRule.registerNextRule(numberRule);

        //When
        var ruleResult = buzzNumberContainsFiveRule.runOn(11);

        //Then
        Assertions.assertThat(ruleResult)
                .isNotNull()
                .isNotEmpty()
                .isEqualTo("11")
                .isNotEqualTo(Onomatopoeia.Buzz.toString());

    }
}