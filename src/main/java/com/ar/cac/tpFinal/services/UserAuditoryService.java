package com.ar.cac.tpFinal.services;

import com.ar.cac.tpFinal.entities.User;
import com.ar.cac.tpFinal.entities.UserAuditory;
import com.ar.cac.tpFinal.entities.dtos.UserAuditoryDto;
import com.ar.cac.tpFinal.entities.dtos.UserDto;
import com.ar.cac.tpFinal.mappers.UserAuditoryMapper;
import com.ar.cac.tpFinal.mappers.UserMapper;
import com.ar.cac.tpFinal.repositories.UserAuditoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuditoryService
{
    @Autowired
    private UserAuditoryRepository userAudRep;



    public void updateAuditory(UserDto dto, User userRestore)
{
    UserAuditory userAuditory = new UserAuditory();

    userAuditory.setAuditoryEmail(dto.getEmail());
    userAuditory.setAuditoryPassword(dto.getPass());
    userAuditory.setAuditoryAddress(dto.getAddress());
    userAuditory.setAuditedAt(LocalDateTime.now());
    userAuditory.setUserAud(userRestore);
    userAudRep.save(userAuditory);

}


    public List<UserAuditoryDto> getAll() {

        List<UserAuditory> usersAudits = userAudRep.findAll();
        List<UserAuditoryDto> usAudDtos = new ArrayList<UserAuditoryDto>();

        for (UserAuditory us : usersAudits) {
            UserAuditoryDto usAudDto = UserAuditoryMapper.userAuditoryToDto(us);
            usAudDtos.add(usAudDto);
        }

        return usAudDtos;

    }
}