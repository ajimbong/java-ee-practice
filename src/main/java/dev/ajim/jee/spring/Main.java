package dev.ajim.jee.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // We are letting Spring provide the
        // classes for us at runtime
        Animal myAnimal = applicationContext.getBean("animal", Animal.class);

        myAnimal.talk();
    }
}
