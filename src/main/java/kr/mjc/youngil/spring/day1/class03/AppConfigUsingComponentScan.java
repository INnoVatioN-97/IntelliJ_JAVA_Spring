package kr.mjc.youngil.spring.day1.class03;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "kr.mjc.youngil.spring.day1.class02")
public class AppConfigUsingComponentScan {
}
