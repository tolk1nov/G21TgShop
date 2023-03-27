package org.example.service.user;

import org.example.domain.DTO.BaseResponse;
import org.example.domain.DTO.UserCreateDTO;
import org.example.domain.DTO.UserStateDTO;
import org.example.domain.model.User;
import org.example.domain.model.UserState;
import org.example.service.BaseService;

public interface UserService extends BaseService<UserCreateDTO, User> {


    BaseResponse<UserStateDTO> getUserState(String chatId);

    void updateState(UserStateDTO stateDTO);
}
