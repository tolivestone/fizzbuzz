package com.fizzbuzz.rules;

public interface Rule {
   Rule registerNextRule(final Rule next);
   String runOn(final int number);
}
