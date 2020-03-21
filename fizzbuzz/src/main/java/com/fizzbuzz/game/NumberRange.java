package com.fizzbuzz.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// This class hold the list of numbers between given range inclusive
public class NumberRange {
    private List<Integer> range;

    NumberRange(List<Integer> range) {
        this.range = range;
    }

    public NumberRange(int start, int end) {

        if(start < 0 || end < 0 || end < start)
            throw new IllegalArgumentException("Invalid argument(s) passed");

        range = IntStream.range(start, end + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getRange() {
        return range;
    }

}
