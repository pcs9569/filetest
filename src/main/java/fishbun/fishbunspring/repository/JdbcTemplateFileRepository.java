package fishbun.fishbunspring.repository;

import fishbun.fishbunspring.domain.FileDomain;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateFileRepository implements FileRepository{

    private final JdbcTemplate jdbcTemplate;
    public JdbcTemplateFileRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public FileDomain insert(FileDomain fileDomain) {
        jdbcTemplate.update("INSERT INTO file (sto_id, file_origin_name, file_save_name, file_size) values (?,?,?,?)",fileDomain.getSto_id(),fileDomain.getFile_origin_name(),fileDomain.getFile_save_name(),fileDomain.getFile_size());
        return fileDomain;
    }
}
