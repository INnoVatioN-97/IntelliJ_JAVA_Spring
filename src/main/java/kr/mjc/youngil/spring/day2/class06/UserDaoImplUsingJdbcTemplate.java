package kr.mjc.youngil.spring.day2.class06;


import kr.mjc.youngil.java.jdbc.user.User;
import kr.mjc.youngil.java.jdbc.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userDao")
public class UserDaoImplUsingJdbcTemplate implements UserDao {
    private static final String LIST_USERS
            = "select userId, email, name from user order by userId desc limit ?,?";

    private static final String ADD_USER
            = "insert user(email, password, name) values(?, sha2(?,256), ?)";

    private static final String LOGIN
            = "select userId, email, name from user where (email, password) = (?, sha2(?,256))";

    private static final String GET_USER
            = "select userId, email, name from user where userId=?";

    private static final String UPDATE_EMAIL
            = "update user set email=? where userId=?";

    private static final String UPDATE_PASSWORD
            = "update user set password=sha2(?,256) where userId=? and password=sha2(?,256)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImplUsingJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*private RowMapper<User> rowMapper = (rs, rowNum) ->{
        User user = new User();
        user.setUserId(rs.getInt("userId"));
        user.setEmail(rs.getString("eamil"));
        user.setName(rs.getString("name"));
        return user;
    };*/
    private RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);

    /**
     * BeanPropertyRowMapper는 고성능 보다는 편리함을 위해 사용한다.
     * 최상의 성능을 위해서는 RowMapper를 직접 구현한다.
     */

    @Override
    public List<User> listUsers(int offset, int count) {
        return jdbcTemplate.query(LIST_USERS, rowMapper, offset, count);
    }

    @Override
    public User login(String email, String password) {
        return jdbcTemplate.queryForObject(LOGIN, rowMapper, email, password);
    }

    //여러개 가져오기 : query
    //한 건 조회 : queryForObject

    @Override
    public User getUser(int userId) {
        return jdbcTemplate.queryForObject(GET_USER, rowMapper, userId);
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(ADD_USER, user.getEmail(), user.getPassword(), user.getName());
    }

    @Override
    public int updateEmail(int userId, String email) {
        return jdbcTemplate.update(UPDATE_EMAIL, email, userId);
    }

    @Override
    public int updatePassword(int userId, String password, String newPassword) {
        return jdbcTemplate.update(UPDATE_PASSWORD, newPassword, userId, password);
    }
}
