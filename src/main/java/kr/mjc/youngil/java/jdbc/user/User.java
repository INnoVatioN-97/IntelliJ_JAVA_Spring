package kr.mjc.youngil.java.jdbc.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    /**
     * @Data : toString, equals, hashCode, getter/setter method를 컴파일시 코드내에 삽입해준다.
     * @NoArgsConstructor : Default Constructor
     * @AllArgsConstructor : 모든 필드를 초기화하는 생성자
     */
    private int userId;
    private String email, name, password;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
