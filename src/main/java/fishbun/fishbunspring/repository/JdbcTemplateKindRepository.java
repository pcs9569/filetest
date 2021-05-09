package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Kind;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateKindRepository implements KindRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateKindRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Kind insert(Kind kind) {
        System.out.println("-----------repository-----------");
        System.out.println(kind.getSto_id());
        System.out.println(kind.getKind_article());
        jdbcTemplate.update("INSERT INTO kind (sto_id, kind_article) VALUES (?,?)", kind.getSto_id(), kind.getKind_article());
        return kind;
    }

    @Override
    public Kind selectById(Integer kind_id) {
        Kind kind = jdbcTemplate.queryForObject("SELECT * FROM kind WHERE kind_id=?", kindRowMapper(), kind_id);
        return kind;
    }

    @Override
    public List<Kind> selectAll() {

        List<Kind> kind = jdbcTemplate.query("SELECT * FROM kind", kindRowMapper());
        return kind;
    }

    @Override
    public void updateKind(Kind kind) {
        jdbcTemplate.update("UPDATE kind SET kind_article=? WHERE kind_id=?",kind.getKind_article(), kind.getKind_id());
    }

    @Override
    public void deleteKind(Kind kind) {
        int result = jdbcTemplate.update("DELETE FROM kind WHERE kind_id = ?", kind.getKind_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Kind> kindRowMapper(){
        return (rs, rowNum) -> {
          Kind kind = new Kind();
          kind.setKind_id(rs.getInt("kind_id"));
          kind.setSto_id(rs.getInt("sto_id"));
          kind.setKind_article(rs.getString("kind_article"));

          return kind;
        };
    }



}
