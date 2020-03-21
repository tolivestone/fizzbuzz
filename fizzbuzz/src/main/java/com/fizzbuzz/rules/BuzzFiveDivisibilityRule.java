package com.fizzbuzz.rules;


import com.fizzbuzz.enums.Onomatopoeia;
import com.fizzbuzz.constant.Constant;

// This rule will check if number is divisible by five else
// call next rule
public class BuzzFiveDivisibilityRule implements Rule {
    private Rule nextRule;

    public BuzzFiveDivisibilityRule() {
    }

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }

    @Override
    public String runOn(final int number) {

        return number > 0 && number % Constant.FIVE == 0
                ? Onomatopoeia.Buzz.toString()
                : nextRule.runOn(number);

    }
}
