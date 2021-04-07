package kr.mjc.youngil.spring.day1.class04;

import kr.mjc.youngil.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUserUsingXmlConfig {
    public static void main(String[] args) {
        //xml 의 <bean...> 로 정의된 빈들을 모두 미리 생성

        //IoC (제어의 역전)
        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "applicationContext04.xml");

        TV samsungTV = context.getBean(SamsungTV.class);
        samsungTV.volumeUp();
        TV lgTV = context.getBean(LgTV.class);
        lgTV.volumeDown();
    }
}
