package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;

import static com.fizzbuzz.constant.Constant.THREE;

// This rule will check if number is divisible by three else
// call next rule
public class FizzThreeDivisibilityRule implements Rule {
    private Rule nextRule;

    public FizzThreeDivisibilityRule() {
    }

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }
    @Override
    public String runOn(final int number) {

        return number > 0 && number % THREE == 0
                ? Onomatopoeia.Fizz.toString()
                : nextRule.runOn(number);
    }
}
