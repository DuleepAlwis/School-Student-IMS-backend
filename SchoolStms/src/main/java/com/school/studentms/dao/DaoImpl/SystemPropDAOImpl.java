package com.school.studentms.dao.DaoImpl;

import com.school.studentms.constants.Query;
import com.school.studentms.dao.SystemPropDAO;
import com.school.studentms.entity.SystemPropEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Component
public class SystemPropDAOImpl implements SystemPropDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long createSystemProp(SystemPropEntity systemPropEntity) {
        return 0;
    }

    @Override
    public long updateSystemProp(SystemPropEntity systemPropEntity) {
        return 0;
    }

    @Override
    public SystemPropEntity getSystemPropByName(String name) {
        return jdbcTemplate.query(Query.GET_SYSTEM_PROP_BY_NAME, new Object[]{name}, new ResultSetExtractor<SystemPropEntity>() {
            @Override
            public SystemPropEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    SystemPropEntity systemPropEntity = new SystemPropEntity();

                    systemPropEntity.setId(rs.getLong("id"));
                    systemPropEntity.setName(rs.getString("name"));
                    systemPropEntity.setValue(rs.getString("value"));
                    Timestamp ts = rs.getTimestamp("createdOn");
                    systemPropEntity.setCreatedOn(ts.toLocalDateTime());
                    return systemPropEntity;

                }
                return null;

            }
        });
    }

    @Override
    public SystemPropEntity getSystemPropById(long id) {
        return null;
    }

    @Override
    public List<SystemPropEntity> getAllSystemProp() {
        return List.of();
    }

    @Override
    public long deleteSystemProp(long id) {
        return 0;
    }
}
