package dev.ajim.jee.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "dev.ajim.jee.spring")
public class AppConfig {

//        @Bean(name = "cowShout")
//        public CowShout cowShout(){
//            return  new CowShout();
//        }
//        @Bean(name = "dogShout")
//        public DogShout dogShout(){
//            return new DogShout();
//        }
//        @Bean(name = "animal")
//        public Animal animal(){
//            // Constructor injection
//            Animal animal = new Animal(cowShout());
//
//            // Setter injection
//            animal.setName("Jamil");
//
//            return animal;
//        }

}
