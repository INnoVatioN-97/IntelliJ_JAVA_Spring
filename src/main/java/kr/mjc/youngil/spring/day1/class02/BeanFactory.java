package kr.mjc.youngil.spring.day1.class02;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    Map<String, Object> map = new HashMap<>();

    /*
     * 생성자에서 인스턴스(빈)을 미리 생성해 맵에 저장.
     */

    public BeanFactory() {
        map.put("samsung", new SamsungTV());
        map.put("lg", new LgTV());
        System.out.println("beanFactory가 빈들을 생성함.");
    }

    public Object getBean(String name){
        return map.get(name);
    }
}
