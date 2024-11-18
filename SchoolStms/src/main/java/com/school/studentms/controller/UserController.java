package com.school.studentms.controller;

import com.school.studentms.constants.RestEndPoints;
import com.school.studentms.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value =RestEndPoints.USER_EP)
@RestController
public class UserController {

	@PostMapping(value= RestEndPoints.TEST_JWT_EP)
    public ResponseEntity<ResponseDTO> testJwtEp(){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success");
        responseDTO.setStatus(true);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
