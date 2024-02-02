package dev.ajim.jee.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

// @Primary | makes cowShout the default Voice class when autowired
public class CowShout implements Voice{
    @Override
    public String shout() {
        return "Shouting like a Cow";
    }
}
