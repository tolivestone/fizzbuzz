package com.fizzbuzz.rules;


import com.fizzbuzz.enums.Onomatopoeia;
import com.fizzbuzz.constant.Constant;

// This rule will check if number is divisible by three and five else
// call next rule
public class FizzBuzzRule implements Rule {
    private Rule nextRule;

    public FizzBuzzRule() {
    }

    public Rule registerNextRule(final Rule next) {

        this.nextRule = next;
        return this.nextRule;
    }

    @Override
    public String runOn(final int number) {

        return number > 0 && number % Constant.FIFTEEN == 0
                ? Onomatopoeia.Fizz.toString() + Onomatopoeia.Buzz.toString()
                : nextRule.runOn(number);
    }
}
