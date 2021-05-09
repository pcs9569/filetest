package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateReviewRepository implements ReviewRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateReviewRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Review insert(Review review) {
        jdbcTemplate.update("insert into review (sto_id, u_email, rev_content, rev_mod_date) values (?,?,?,NOW())", review.getSto_id(), review.getU_email(), review.getRev_content());
        return review;
    }

    @Override
    public Review selectById(Integer rev_id) {
        Review review = jdbcTemplate.queryForObject("select * from review where rev_id=?", reviewRowMapper(), rev_id);
        return review;
    }

    @Override
    public List<Review> selectAll() {
        return jdbcTemplate.query("SELECT * FROM review", reviewRowMapper());
    }

    @Override
    public Review updateReview(Review review) {
        jdbcTemplate.update("UPDATE review SET rev_content=?, rev_mod_date=NOW() WHERE rev_id=?", review.getRev_content(), review.getRev_id());
        return review;

    }

    @Override
    public void deleteReview(Review review) {
        int result = jdbcTemplate.update("DELETE FROM review WHERE rev_id =?", review.getRev_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Review> reviewRowMapper(){
        return (rs, rowNum) -> {
          Review review = new Review();
          review.setRev_id(rs.getInt("rev_id"));
          review.setSto_id(rs.getInt("sto_id"));
          review.setU_email(rs.getString("u_email"));
          review.setRev_content(rs.getString("rev_content"));

          return review;
        };

    }











}
