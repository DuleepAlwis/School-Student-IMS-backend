package com.school.studentms.dao.DaoImpl;

import com.school.studentms.constants.Query;
import com.school.studentms.dao.OrganizationDAO;
import com.school.studentms.entity.OrganizationEntity;
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
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long createOrganization(OrganizationEntity org) {
        long result = jdbcTemplate.update(Query.CREATE_NEW_ORGANIZATION,org.getOrgName(),org.getCity(),org.getAddress(),org.getDistrict(),org.getOrgCode()
        ,org.getIsActive(),org.getCreatedOn(),org.getEmail(),org.getProfilePic());
        return result;
    }

    @Override
    public long updateOrganization(OrganizationEntity org) {
        return 0;
    }

    @Override
    public OrganizationEntity getOrganizationByEmail(String email) {
        OrganizationEntity organizationEntity = null;
        organizationEntity = jdbcTemplate.query(Query.GET_ORG_BY_EMAIL, new Object[]{email}, new ResultSetExtractor<com.school.studentms.entity.OrganizationEntity>() {
            @Override
            public OrganizationEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                OrganizationEntity org = new OrganizationEntity();
                if(rs.next()){
                    org.setId(rs.getLong("id"));
                    org.setEmail(rs.getString("email"));
                    org.setCity(rs.getString("city"));
                    org.setOrgCode(rs.getString("orgCode"));
                    org.setAddress(rs.getString("address"));
                    org.setDistrict(rs.getString("district"));
                    org.setOrgName(rs.getString("orgName"));
                    org.setIsActive(rs.getString("isActive"));
                    Timestamp ts = rs.getTimestamp("createdOn");
                    org.setCreatedOn(ts.toLocalDateTime());
                    org.setProfilePic(rs.getString("profile_pic"));
                }
                return org;
            }
        });
        return organizationEntity;
    }


    @Override
    public OrganizationEntity getOrganizationById(long id) {
        OrganizationEntity organizationEntity = jdbcTemplate.query(Query.GET_ORG_BY_ID, new Object[]{id}, new ResultSetExtractor<com.school.studentms.entity.OrganizationEntity>() {
            @Override
            public OrganizationEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                OrganizationEntity org = new OrganizationEntity();
                if(rs.next()){
                    org.setId(rs.getLong("id"));
                    org.setEmail(rs.getString("email"));
                    org.setCity(rs.getString("city"));
                    org.setOrgCode(rs.getString("orgCode"));
                    org.setAddress(rs.getString("address"));
                    org.setDistrict(rs.getString("district"));
                    org.setOrgName(rs.getString("orgName"));
                    org.setIsActive(rs.getString("isActive"));
                    Timestamp ts = rs.getTimestamp("createdOn");
                    org.setCreatedOn(ts.toLocalDateTime());
                    org.setProfilePic(rs.getString("profile_pic"));
                }
                return org;
            }
        });
        return organizationEntity;
    }

    @Override
    public List<OrganizationEntity> getAllOrganizations() {
        return List.of();
    }

    @Override
    public long deleteOrganization(long id) {
        return 0;
    }
}
