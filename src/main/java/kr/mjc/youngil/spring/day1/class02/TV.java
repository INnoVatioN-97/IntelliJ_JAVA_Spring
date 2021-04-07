package kr.mjc.youngil.spring.day1.class02;

//default method 로 굳이 따로 구현안하고도 쓸수있게.
public interface TV {
    default void powerOn(){
        System.out.printf("%s power on. \n", getClass().getSimpleName());
    }
    default void powerOff(){
        System.out.printf("%s power off. \n", getClass().getSimpleName());
    }
    default void volumeUp(){
        System.out.printf("%s volume up. \n", getClass().getSimpleName());
    }
    default void volumeDown(){
        System.out.printf("%s volume down. \n", getClass().getSimpleName());
    }

}
