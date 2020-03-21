package com.fizzbuzz.rules;

// Chain of responsibility pattern
// Class which creates composite rules and runs each rule on a given number
// Add any new rule to this class.

import org.springframework.stereotype.Component;

@Component
public class CompositeRules implements Rule {

    private final Rule fizzBuzzRule;

    public CompositeRules() {

        fizzBuzzRule = new FizzBuzzRule();                                  // Checks for 3 and 5 divisibility
        fizzBuzzRule
                    .registerNextRule(new FizzThreeDivisibilityRule())      // Checks for three divisibility
                    .registerNextRule(new FizzNumberContainsThreeRule())    // Phase#2 requirement contains number 3
                    .registerNextRule(new BuzzFiveDivisibilityRule())       // checks for five divisibilyt
                    .registerNextRule(new BuzzNumberContainsFiveRule())     // Phase#2 requirement contains 5
                    .registerNextRule(new NumberRule());                    // Returns Number
    }

    @Override
    public Rule registerNextRule(Rule next) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String runOn(final int number) {
        return fizzBuzzRule.runOn(number);
    }
}
