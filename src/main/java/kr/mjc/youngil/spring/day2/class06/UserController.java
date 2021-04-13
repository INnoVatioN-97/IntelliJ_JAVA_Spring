package kr.mjc.youngil.spring.day2.class06;

import kr.mjc.youngil.java.jdbc.user.User;
import kr.mjc.youngil.java.jdbc.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(@Qualifier("userDao") UserDao userDao) {
        this.userDao = userDao;
        System.out.printf("userController에 %s 빈을 주입했습니다.\n", userDao.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class);
        UserController userController = context.getBean(UserController.class);
        System.out.print(
                "Select method (1:list, 2:get, 3:login, 4:add, 5:updatePassword, 6:updateEmail) : ");
        try (Scanner scanner = new Scanner(System.in)) {
            switch (scanner.nextInt()) { //새로운 switch-case 문
                case 1 -> userController.list();
                case 2 -> userController.get();
                case 3 -> userController.login();
                case 4 -> userController.add();
                case 5 -> userController.updatePassword();
                case 6 -> userController.updateEmail();
            }
        }
    }

    public void list() {
        List<User> userList = userDao.listUsers(0, 10);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void get() {
        int userId = 1;
        try {
            User user = userDao.getUser(userId);
            System.out.println(user);
        } catch (EmptyResultDataAccessException e) {
            //queryForObject() 는 resultSet 이 없으면 EmptyResultDataAccessException을 발생한다.
            System.err.format("데이터가 없습니다. userId=%s", userId);
        }
    }

    public void login() {
        try {
            User user = userDao.login("byung@daum.net", "b");
            System.out.printf("%s님 로그인 했습니다.", user.getName());
        } catch (EmptyResultDataAccessException e) {
            System.err.println("이메일 또는 아이디가 틀립니다.");
        }
    }

    public void add() {
        User user = new User();
        user.setEmail("david@gmail.net");
        user.setName("데이빗");
        user.setPassword("a");
        try {
            userDao.addUser(user);
            System.out.format("사용자를 추가했습니다 : %s\n", user);
        } catch (DuplicateKeyException e) {
            // update()는 키가 중복되면 DuplicateKeyException을 던진다.
            System.err.format("이메일 중복입니다. email=%s\n", user.getEmail());
        }
    }

    public void updatePassword() {
        int updatedRows = userDao.updatePassword(3, "1", "xxxx");
        if (updatedRows > 0)
            System.out.println("비밀번호를 업데이트 했습니다.");
        else
            System.err.println("사용자가 없거나 비밀번호가 틀립니다.");
    }

    public void updateEmail() {
        int userId = 2;
        String email = "iu@daum.net";
        try {
            int updatedRows = userDao.updateEmail(userId, email);
            if (updatedRows > 0)
                System.out.println("이메일을 업데이트 했습니다.");
            else
                System.err.format("사용자가 없습니다. userId=%d\n", userId);
        } catch (DataAccessException e) {
            // update()는 키가 중복되면 DuplicateKeyException을 던진다.
            System.err.format("이메일 중복입니다. email=%s\n", email);
        }
    }
}