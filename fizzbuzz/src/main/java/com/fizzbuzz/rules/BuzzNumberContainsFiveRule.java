package com.fizzbuzz.rules;

import com.fizzbuzz.enums.Onomatopoeia;

import static com.fizzbuzz.constant.Constant.FIVE;

// This rule will check if number contains five else
// call next rule
public class BuzzNumberContainsFiveRule implements Rule {
    private Rule nextRule;

    public BuzzNumberContainsFiveRule() {
    }

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }

    @Override
    public String runOn(final int number) {

        return number > 0 && String.valueOf(number).contains(String.valueOf(FIVE))
                ? Onomatopoeia.Buzz.toString()
                : nextRule.runOn(number);
    }
}
