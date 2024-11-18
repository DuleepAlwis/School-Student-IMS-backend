package com.school.studentms.controller;

import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.constants.RestEndPoints;
import com.school.studentms.dto.OrganizationDTO;
import com.school.studentms.dto.ResponseDTO;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.service.OrganizationService;
import com.school.studentms.service.ServiceImpl.OrganizationServiceImpl;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value= RestEndPoints.ORGANIZATION_EP)
@RestController
public class OrganizationController {

    private static final Logger logger = LogManager.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = RestEndPoints.ORGANIZATION_CREATE_EP)
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody OrganizationDTO org, BindingResult result) {
        ResponseDTO response = new ResponseDTO();
        if(result.hasErrors()){
            response.setStatus(false);
            response.setMessage(result.getFieldError("email").getDefaultMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }else{
            try{
                logger.info("Org DTO {}",org);
                long res = organizationService.createOrganization(org);
                if (res>0) {
                    response.setStatus(true);
                    response.setMessage(ResponseMessage.ORG_CREATION_SUCCESS);
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    throw new TransactionFailedException(ResponseMessage.ORG_CREATION_FAILED);
                }
            } catch (TransactionFailedException e) {
                response.setStatus(false);
                response.setMessage(e.getMessage());
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
