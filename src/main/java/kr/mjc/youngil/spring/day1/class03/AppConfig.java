package kr.mjc.youngil.spring.day1.class03;

import kr.mjc.youngil.spring.day1.class02.LgTV;
import kr.mjc.youngil.spring.day1.class02.SamsungTV;
import kr.mjc.youngil.spring.day1.class02.TV;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
 * XML-based configuration
 * 빈들을 xml로 구성해 간결하고 중앙 집중적. 오타로 인한 런타임 구성 실패 가능성 있다.
 *
 * Java-based configuration
 * 빈들을 Java 클래스로 구성해 중앙 집중적이고, 컴파일 타임에 구성 오류를 찾아낸다.
 *
 * Component scan
 * 분산적 구성. 침습적이다.
 */
@Configuration
public class AppConfig {
    @Bean
    public TV samsungTV(){
        return new SamsungTV();
    }

    @Bean
    public TV lgTV(){
        return new LgTV();
    }
}
