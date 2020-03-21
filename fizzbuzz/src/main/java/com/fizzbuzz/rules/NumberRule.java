package com.fizzbuzz.rules;

// This class will return number if no any other rules apply
public class NumberRule implements Rule {
    private Rule nextRule;

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }

    @Override
    public String runOn(final int number) {
        return String.valueOf(number);
    }
}
