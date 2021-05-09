package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Notify;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateNotifyRepository implements NotifyRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateNotifyRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(Notify notify) {
        jdbcTemplate.update("INSERT INTO notify (sto_id, u_email, noti_content, noti_type) VALUES (?,?,?,?)", notify.getSto_id(),notify.getU_email(),notify.getNoti_content(),notify.getNoti_type());
    }

    @Override
    public Notify selectById(Integer noti_id) {
        Notify notify = jdbcTemplate.queryForObject("SELECT * FROM notify WHERE noti_id=?", notifyRowMapper(),noti_id);
        return notify;
    }

    @Override
    public List<Notify> selectAll() {
        List<Notify> notifyList = jdbcTemplate.query("SELECT * FROM notify", notifyRowMapper());
        return notifyList;
    }

    @Override
    public void updateNotify(Notify notify) {
        jdbcTemplate.update("UPDATE notify SET noti_content=?, noti_type=? WHERE noti_id=?", notify.getNoti_content(), notify.getNoti_type(), notify.getNoti_id());
    }

    @Override
    public void deleteNotify(Notify notify) {
        int result = jdbcTemplate.update("DELETE FROM notify WHERE noti_id =? ", notify.getNoti_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Notify> notifyRowMapper(){
        return (rs, rowNum) -> {
          Notify notify = new Notify();
          notify.setNoti_id(rs.getInt("noti_id"));
          notify.setSto_id(rs.getInt("sto_id"));
          notify.setU_email(rs.getString("u_email"));
          notify.setNoti_content(rs.getString("noti_content"));
          notify.setNoti_type(rs.getInt("noti_type"));

          return notify;
        };
    }

}
