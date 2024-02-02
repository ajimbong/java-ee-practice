package dev.ajim.jee.spring;

import org.springframework.stereotype.Component;

@Component
public class DogShout implements Voice{
    @Override
    public String shout() {
        return "Shouting Like a Dog";
    }
}
