package kr.mjc.youngil.spring.day1.class02;

import java.util.Scanner;

public class TvUserUsingFactory {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        System.out.print("Input bean's name : ");
        //try - with resources 문
        try(Scanner sc = new Scanner(System.in)){ //finally 에서 sc.close()를 안해도 자동 close 된다.
            String name = sc.next();
            TV tv = (TV) beanFactory.getBean(name);
            tv.powerOn();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
