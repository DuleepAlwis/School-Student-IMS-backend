package com.school.studentms.dao.DaoImpl;

import com.school.studentms.constants.Query;
import com.school.studentms.dao.UserDAO;
import com.school.studentms.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity getUserByEmail(String email) {
        try{
            UserEntity ue = jdbcTemplate.query(Query.GET_USER_BY_EMAIL, new Object[]{email}, new ResultSetExtractor<UserEntity>() {
                @Override
                public UserEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                    UserEntity u = new UserEntity();
                    if(rs!=null && rs.next()){
                        u.setId(rs.getLong("id"));
                        u.setEmail(rs.getString("email"));
                        u.setIsActive(rs.getString("isActive"));
                        u.setMobile(rs.getString("mobile"));
                        u.setCountry(rs.getString("country"));
                        u.setOrg(rs.getLong("orgId"));
                        u.setUserRole(rs.getLong("roleId"));
                        Timestamp ts = rs.getTimestamp("createdOn");
                        u.setCreatedOn(ts.toLocalDateTime());
                        u.setPassword(rs.getString("password"));
                        return u;
                    }else{
                        return null;
                    }

                }
            });
            return ue;
        }catch (EmptyResultDataAccessException e) {
            // Handle the case where no user is found
            return null;
        }

    }

    @Override
    public UserEntity getUserById(long id) {
        UserEntity ue = jdbcTemplate.query(Query.GET_USER_BY_ID, new Object[]{id}, new ResultSetExtractor<UserEntity>() {
            @Override
            public UserEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                UserEntity u = new UserEntity();
                u.setId(Long.parseLong(rs.getString("id")));
                u.setEmail(rs.getString("email"));
                u.setIsActive(rs.getString("isActive"));
                u.setMobile(rs.getString("mobile"));
                u.setCountry(rs.getString("country"));
                u.setOrg(Long.parseLong(rs.getString("orgId")));
                u.setUserRole(Long.parseLong(rs.getString("roleId")));
                u.setCreatedOn(LocalDateTime.parse(rs.getString("createdOn")));

                return u;
            }
        });
        return ue;
    }

    @Override
    public long createUser(UserEntity ue) {

        int result = jdbcTemplate.update(Query.CREATE_NEW_USER,ue.getEmail(),ue.getMobile(),ue.getIsActive(),ue.getCountry(),ue.getPassword(),ue.getCreatedOn(),
                ue.getUserRole()==0?null:ue.getUserRole(),ue.getOrg()==0?null:ue.getOrg(),ue.getOtp(),ue.getProfilePic());
        return result;
    }

    @Override
    public long updateUser(UserEntity ue) {
        return 0;
    }

    @Override
    public long changePassword(UserEntity ue) {
        return 0;
    }

    @Override
    public long sendPasswordResetEmail(String email) {
        return 0;
    }

    @Override
    public long deleteUser(long id) {
        return 0;
    }
}
