package kr.mjc.youngil.spring.day1.class02;

public class TvUser {
    public static void main(String[] args) {
        //Interface 타입에 구현체를 담으면 구현체의 메소드를 실행 가능하다.
        TV tv = new LgTV();
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
