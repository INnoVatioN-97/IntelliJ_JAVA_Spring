package kr.mjc.youngil.spring.day1.class04;

public interface Speaker {
    default void volumeUp() {
        System.out.printf("%s - volume up. \n", getClass().getSimpleName());
    }

    default void volumeDown() {
        System.out.printf("%s - volume down. \n", getClass().getSimpleName());
    }
}
