package com.fizzbuzz.rules;


import com.fizzbuzz.enums.Onomatopoeia;

import static com.fizzbuzz.constant.Constant.THREE;

// This rule will check if number contains three else
// call next rule
public class FizzNumberContainsThreeRule implements Rule {
    private Rule nextRule;

    public FizzNumberContainsThreeRule() {
    }

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }

    @Override
    public String runOn(final int number) {

        return number > 0 && String.valueOf(number).contains(String.valueOf(THREE))
                ? Onomatopoeia.Fizz.toString()
                : nextRule.runOn(number);
    }
}
