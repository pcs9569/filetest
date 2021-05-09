package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Likes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateLikesRepository implements LikesRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateLikesRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Likes insert(Likes likes) {
        jdbcTemplate.update("INSERT INTO likes (sto_id, u_email, likes_press) values (?,?,?)", likes.getSto_id(), likes.getU_email(),likes.getLikes_press());
        return likes;
    }

    @Override
    public Likes selectById(Integer likes_id) {
        Likes likes = jdbcTemplate.queryForObject("SELECT * FROM likes WHERE likes_id=?", likesRowMapper(), likes_id);
        return likes;
    }

    @Override
    public List<Likes> selectAll() {
        return jdbcTemplate.query("SELECT * FROM likes", likesRowMapper());
    }

    @Override
    public Likes updateLikes(Likes likes) {
        jdbcTemplate.update("UPDATE likes SET likes_press=?", likes.getLikes_press());
        return likes;
    }

    @Override
    public void deleteLikes(Likes likes) {
        int result = jdbcTemplate.update("DELETE FROM likes WHERE likes_id=?", likes.getLikes_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Likes> likesRowMapper(){
        return (rs, rowNum) -> {
            Likes likes = new Likes();
            likes.setLikes_id(rs.getInt("likes_id"));
            likes.setSto_id(rs.getInt("sto_id"));
            likes.setU_email(rs.getString("u_email"));
            likes.setLikes_press(rs.getInt("likes_press"));

            return likes;
        };
    }


}
