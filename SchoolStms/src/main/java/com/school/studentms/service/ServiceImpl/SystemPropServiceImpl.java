package com.school.studentms.service.ServiceImpl;

import com.school.studentms.constants.ResponseMessage;
import com.school.studentms.dao.SystemPropDAO;
import com.school.studentms.dto.SystemPropDTO;
import com.school.studentms.entity.SystemPropEntity;
import com.school.studentms.exception.TransactionFailedException;
import com.school.studentms.service.SystemPropService;
import com.school.studentms.utility.ModelMapperConfig;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SystemPropServiceImpl implements SystemPropService {

    @Autowired
    private SystemPropDAO systemPropDAO;

    @Autowired
    private ModelMapperConfig modelMapperConfig;

    @Override
    public long createSystemProp(SystemPropDTO systemPropDTO) {
        return 0;
    }

    @Override
    public long updateSystemProp(SystemPropDTO systemPropDTO) {
        return 0;
    }

    @Override
    @Transactional
    public SystemPropDTO getSystemPropByName(String name) {

        try{
            SystemPropEntity systemPropEntity = systemPropDAO.getSystemPropByName(name);
            if(systemPropEntity!=null){
                SystemPropDTO systemPropDTO = modelMapperConfig.modelMapper().map(systemPropEntity,SystemPropDTO.class);
                return systemPropDTO;
            }else{
                throw new TransactionFailedException(ResponseMessage.SYS_PROP_NOT_FOUND);
            }
        }catch (Exception ex){
            throw new TransactionFailedException(ex.getMessage());
        }

    }

    @Override
    public SystemPropDTO getSystemPropById(long id) {
        return null;
    }

    @Override
    public List<SystemPropDTO> getAllSystemProp() {
        return List.of();
    }

    @Override
    public long deleteSystemProp(long id) {
        return 0;
    }
}
