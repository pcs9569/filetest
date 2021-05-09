package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.Store;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;

import java.time.LocalDateTime;
import java.util.List;


public class JdbcTemplateStoreRepository implements StoreRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateStoreRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Store insert(Store store) {

        jdbcTemplate.update("insert into store (sto_name, sto_picture, sto_detail_option, sto_lat, sto_lon, sto_mod_date) values (?,?,?,?,?,NOW())", store.getSto_name(), store.getSto_picture(), store.getSto_detail_option(), store.getSto_lat(), store.getSto_lon());

        return store;

    }

    @Override
    public Store selectById(Integer sto_id) {
        Store store = jdbcTemplate.queryForObject("select * from store where sto_id = ?", storeRowMapper(), sto_id);

        return store;
    }

    @Override
    public List<Store> selectAll() {
        return jdbcTemplate.query("select * from store", storeRowMapper());
    }

    @Override
    public Store updateStore(Store store) {

        jdbcTemplate.update("UPDATE store SET sto_name = ?, sto_picture = ?, sto_detail_option = ?, sto_lat = ?, sto_lon = ?, sto_mod_date=NOW()  WHERE sto_id = ?", store.getSto_name(), store.getSto_picture(), store.getSto_detail_option(), store.getSto_lat(), store.getSto_lon(), store.getSto_id());

        return store;
    }

    @Override
    public void deleteStore(Store store) {
        int result = jdbcTemplate.update("DELETE FROM store WHERE sto_id = ?", store.getSto_id());
        System.out.println(result+"개 행 삭제 성공");
    }

    private RowMapper<Store> storeRowMapper(){
        return (rs, rowNum) -> {
            Store store = new Store();
            store.setSto_id(rs.getInt("sto_id"));
            store.setSto_name(rs.getString("sto_name"));
            store.setSto_detail_option(rs.getString("sto_detail_option"));
            store.setSto_picture(rs.getString("sto_picture"));
            store.setSto_lat(rs.getDouble("sto_lat"));
            store.setSto_lon(rs.getDouble("sto_lon"));

            return store;
        };
    }

}
