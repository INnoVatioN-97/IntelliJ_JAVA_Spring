package kr.mjc.youngil.spring.day1.class03;

import kr.mjc.youngil.spring.day1.class02.LgTV;
import kr.mjc.youngil.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUserUsingXmlBasedConfiguration {
    public static void main(String[] args) {
        //xml 의 <bean...> 로 정의된 빈들을 모두 미리 생성해
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext03.xml");

        // by-name lookup.
        TV samsungTV = (TV) context.getBean("samsungTV");
        samsungTV.powerOn();
        samsungTV.powerOff();

        // by-type lookup. 알아서 타입이 LgTV 인걸 찾아서 넣어준다.
        TV lgTV = context.getBean((LgTV.class));
        lgTV.powerOn();
        lgTV.powerOff();
    }
}
