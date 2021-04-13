package kr.mjc.youngil.spring.day1.user.componentscan;

import kr.mjc.youngil.java.jdbc.user.User;
import kr.mjc.youngil.java.jdbc.user.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;

public class ListUsersEx {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class
        );

        UserDao userDao = context.getBean("userDao", UserDao.class);
        List<User> userList = userDao.listUsers(0,10);
        for(User user:userList){
            System.out.println(user);
        }
    }
}
