package kr.mjc.youngil.spring.day1.class04;

import org.springframework.stereotype.Component;

@Component("sonySpeaker")
public class SonySpeaker implements Speaker {

    public SonySpeaker() {
        System.out.println("sonySpeaker instance is created.");
    }
}
