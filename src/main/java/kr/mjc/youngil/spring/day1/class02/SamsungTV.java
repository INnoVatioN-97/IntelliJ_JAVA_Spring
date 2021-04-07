package kr.mjc.youngil.spring.day1.class02;

import org.springframework.stereotype.Component;

@Component
public class SamsungTV implements TV{
    public SamsungTV(){
        System.out.println("Samsung TV is created.");
    }
}
