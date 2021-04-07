package kr.mjc.youngil.spring.day1.class04;

import kr.mjc.youngil.spring.day1.class02.LgTV;
import kr.mjc.youngil.spring.day1.class02.SamsungTV;
import kr.mjc.youngil.spring.day1.class02.TV;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUserUsingJavaConfig {
    public static void main(String[] args) {
        // @Configuration 클래스의 @Bean 으로 정의된 빈들을 모두 생성해 가져온다.
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TV samsungTV = context.getBean(SamsungTV.class);
        samsungTV.volumeUp();
        TV lgTV = context.getBean(LgTV.class);
        lgTV.volumeDown();
    }
}
