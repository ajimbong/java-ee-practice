package dev.ajim.jee.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Animal {
    private String name = "Rex";
    private Voice voice;

    @Autowired
    public Animal(@Qualifier("dogShout") Voice voice) {
        this.voice = voice;
    }
    public void talk(){
        System.out.println("Hello I am " + name + " " + voice.shout());
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
