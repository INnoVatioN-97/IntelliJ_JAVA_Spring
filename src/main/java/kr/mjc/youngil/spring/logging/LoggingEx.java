package kr.mjc.youngil.spring.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Slf4j를 적으면 밑에 Logger log = ~~를 빼도 된다.
@Slf4j
public class LoggingEx {
//    private static final Logger log =
//            LoggerFactory.getLogger(LoggingEx.class);

    public static void main(String[] args) {
        log.trace("로거 구현체 : {}", log.getClass().getName());
        log.debug("로거 구현체 : {}", log.getClass().getName());
        log.info("로거 구현체 : {}", log.getClass().getName());
        log.error("로거 구현체 : {}", log.getClass().getName());

        // 다음과 같이 문자열 연산을 하지 않는다.
//        log.error("로거 구현체 : "+ log.getClass().getName());

    }
}
