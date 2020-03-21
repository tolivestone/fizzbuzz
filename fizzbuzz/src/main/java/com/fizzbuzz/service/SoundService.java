package com.fizzbuzz.service;

import com.fizzbuzz.rules.Rule;
import org.springframework.stereotype.Service;

//Service class generates sounds based on game rules.
@Service
public class SoundService implements Sound{
    private final Rule rule;

    public SoundService(final Rule rule) {
        this.rule = rule;
    }

    @Override
    public String generate(int number){
        return rule.runOn(number);
    }
}
