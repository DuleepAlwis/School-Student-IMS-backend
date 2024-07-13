package com.school.studentms.service.ServiceImpl;

import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.constants.Role;
import com.school.studentms.dao.OrganizationDAO;
import com.school.studentms.dto.OrganizationDTO;
import com.school.studentms.dto.UserDTO;
import com.school.studentms.entity.OrganizationEntity;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.service.OrganizationService;
import com.school.studentms.service.UserService;
import com.school.studentms.utility.ModelMapperConfig;
import com.school.studentms.utility.ApplicationUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationDAO organizationDAO;

    @Autowired
    private ModelMapperConfig modelMapperConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    private static final Logger logger = LogManager.getLogger(OrganizationServiceImpl.class);

    @Override
    @Transactional
    public long createOrganization(OrganizationDTO org) {


        long resultOrg = 0;
        long resultUser = 0;
        try{
            if(organizationDAO.getOrganizationByEmail(org.getEmail()).getId()==0){
                org.setCreatedOn(LocalDateTime.now());
                org.setOrgCode(ApplicationUtility.generateOrgCode(org.getOrgName()));
                org.setIsActive("Y");
                OrganizationEntity organizationEntity = modelMapperConfig.modelMapper().map(org,OrganizationEntity.class);
                resultOrg = organizationDAO.createOrganization(organizationEntity);
                logger.info("Organization successfully created {}",org.getEmail());
                if(resultOrg>0){
                    UserDTO userDTO = new UserDTO();
                    String tmpPassword = ApplicationUtility.generateTmpPassword(org.getEmail());
                    userDTO.setPassword(ApplicationUtility.generatePassword(tmpPassword));
                    userDTO.setEmail(org.getEmail());
                    userDTO.setCreatedOn(LocalDateTime.now());
                    userDTO.setIsActive("Y");
                    userDTO.setUserRole(Role.ORG_ADMIN.getIndex());
                    resultUser = userService.createUser(userDTO);
                    String emailBody = "<h3>Hi user</h3><p>Your user account has been creadted and your organization succeccfully registered in our system."+
                            "Use this tempory password to login to the system and change your password. Tempory password : <b>"+tmpPassword+"</b>";
                    mailSenderService.sendNewMail(org.getEmail(),ResponseMessage.USER_ACCOUNT_CREATED,emailBody);
                    if(resultUser>0){
                        return resultUser+resultOrg;
                    }else{
                        logger.error("Error in creating the user {}",userDTO.getEmail());
                        throw new TransactionFailedException("Error in creating the user "+ResponseMessage.USER_CREATION_FAILED);
                    }
                }else{
                    logger.error("Error in creating the organization {}",org.getEmail());
                    throw new TransactionFailedException("Error in creating the organization "+ResponseMessage.ORG_CREATION_FAILED);

                }

            }else {
                logger.error("Organization exists {}",org.getEmail());
                throw new TransactionFailedException("Error in creating the organization "+ResponseMessage.ORG_EXISTS);

            }
        }catch (Exception ex){
            throw new TransactionFailedException("Transactional error "+ex.getMessage());
        }
    }

    @Override
    public long updateOrganization(OrganizationDTO org) {
        return 0;
    }

    @Override
    @Transactional
    public OrganizationDTO getOrganizationByEmail(String email) {
        OrganizationDTO organizationDTO;
        try{
            OrganizationEntity organizationEntity = organizationDAO.getOrganizationByEmail(email);
            if(organizationEntity!=null && organizationEntity.getId()>0){
                logger.info("Organization found {}, {}",organizationEntity.getOrgName(),email);
                organizationDTO = modelMapperConfig.modelMapper().map(organizationEntity,OrganizationDTO.class);
                return organizationDTO;
            }else{
                logger.error("Organization not found {}",email);
                throw new TransactionFailedException(ResponseMessage.ORG_NOT_FOUND);
            }
        }catch (Exception ex){
            logger.error("Organization processing error {} {}",ex.getMessage(),email);
            throw new TransactionFailedException("Transaction failed "+ex.getMessage());
        }
    }

    @Override
    public OrganizationDTO getOrganizationById(long id) {
        OrganizationDTO organizationDTO;
        try{
            OrganizationEntity organizationEntity = organizationDAO.getOrganizationById(id);
            if(organizationEntity!=null){
                logger.info("Organization found {}, {}",organizationEntity.getOrgName(),id);
                organizationDTO = modelMapperConfig.modelMapper().map(organizationEntity,OrganizationDTO.class);
                return organizationDTO;
            }else{
                logger.error("Organization not found {}",id);
                throw new TransactionFailedException(ResponseMessage.ORG_NOT_FOUND);
            }
        }catch (Exception ex){
            logger.error("Organization processing error {} {}",ex.getMessage(),id);
            throw new TransactionFailedException("Transaction failed "+ex.getMessage());
        }
    }

    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        return List.of();
    }

    @Override
    public long deleteOrganization(long id) {
        return 0;
    }
}
