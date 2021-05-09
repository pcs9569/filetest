package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Star;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateStarRepository implements StarRepository {

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateStarRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Star insert(Star star) {
        jdbcTemplate.update("INSERT INTO star (sto_id, u_email, star_point) VALUES (?,?,?)", star.getSto_id(), star.getU_email(), star.getStar_point());
        return star;
    }

    @Override
    public Star selectById(Integer star_id) {
        Star star = jdbcTemplate.queryForObject("SELECT * FROM star WHERE star_id=?", starRowMapper(), star_id);
        return star;
    }

    @Override
    public List<Star> selectAll() {
        return jdbcTemplate.query("SELECT * FROM star", starRowMapper());
    }

    @Override
    public Star updateStar(Star star) {
        jdbcTemplate.update("UPDATE star SET star_point=? WHERE star_id=?", star.getStar_point(), star.getStar_id());
        return star;
    }

    @Override
    public void deleteStar(Star star) {

        int result = jdbcTemplate.update("DELETE FROM star WHERE star_id=?", star.getStar_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Star> starRowMapper(){
        return (rs, rowNum) -> {
            Star star = new Star();
            star.setStar_id(rs.getInt("star_id"));
            star.setSto_id(rs.getInt("sto_id"));
            star.setU_email(rs.getString("u_email"));
            star.setStar_point(rs.getInt("star_point"));

            return star;
        };
    }


}
