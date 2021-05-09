package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateUserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    /*
        @Override
        public User save(User user) {
            SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

            System.out.println("--------------------" + "repository" + "-------------------------------");
            System.out.println(user.getU_email());
            System.out.println(user.getU_name());
            System.out.println(user.getU_pw());
            System.out.println(user.getU_level());


            jdbcInsert.withTableName("user");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("u_email", user.getU_email());
            parameters.put("u_name", user.getU_name());
            parameters.put("u_pw", user.getU_pw());
            parameters.put("u_level", user.getU_level());
            return user;
        }
    */
    @Override
    public User insert(User user) {
        //SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        System.out.println("--------------------" + "repository" + "-------------------------------");
        System.out.println(user.getU_email());
        System.out.println(user.getU_name());
        System.out.println(user.getU_pw());

        jdbcTemplate.update("insert into user (u_email, u_name, u_pw) values (?,?,?)", user.getU_email(), user.getU_name(),user.getU_pw());

        return user;

    }

    @Override
    public User selectByEmail(String u_email) {
        User user = jdbcTemplate.queryForObject("select * from user where u_email = ?", userRowMapper(), u_email);
//        return result.stream().findAny();
        return user;
    }
//
//    @Override
//    public Optional<User> findByName(String u_name) {
//        return Optional.empty();
//    }

    @Override
    public User updateUser(User user){
        System.out.println("--------------------" + "repository" + "-------------------------------");
        System.out.println(user.getU_email());
        System.out.println(user.getU_name());
        System.out.println(user.getU_pw());

        jdbcTemplate.update("UPDATE user SET u_name = ?, u_pw = ?, u_level = ?  WHERE u_email = ?", user.getU_name(), user.getU_pw(),user.getU_level(), user.getU_email());

        return user;
    }

    @Override
    public List<User> selectAll() {
        return jdbcTemplate.query("select * from user", userRowMapper());
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setU_email(rs.getString("u_email"));
            user.setU_name(rs.getString("u_name"));
            user.setU_pw(rs.getString("u_pw"));
            user.setU_date(rs.getString("u_date"));
            user.setU_level(rs.getInt("u_level"));
            return user;
        };
    }


    public void deleteUser(User user){
        int result = jdbcTemplate.update("DELETE FROM user WHERE u_email = ?", user.getU_email());
        System.out.println(result+"개 행 삭제 성공");
    }
}
