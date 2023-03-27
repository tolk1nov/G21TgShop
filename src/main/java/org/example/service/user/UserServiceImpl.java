package org.example.service.user;

import org.example.domain.DTO.BaseResponse;
import org.example.domain.DTO.UserCreateDTO;
import org.example.domain.DTO.UserStateDTO;
import org.example.domain.model.User;
import org.example.domain.model.UserState;
import org.example.repository.user.UserRepository;
import org.example.repository.user.UserRepositoryImpl;
import org.example.util.BeanUtil;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = UserRepositoryImpl.getInstance();
    private final ModelMapper modelMapper = BeanUtil.getModelMapper();

    @Override
    public BaseResponse save(UserCreateDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setState(UserState.START);

        int save = userRepository.save(user);

        if(save == 200) {
            return new BaseResponse("Success", 200);
        }
        return new BaseResponse("Fail", 500);
    }

    @Override
    public BaseResponse<User> getById(UUID id) {
        return null;
    }

    @Override
    public BaseResponse<UserStateDTO> getUserState(String chatId) {

        Optional<User> userByChatId = userRepository.findUserByChatId(chatId);
        if(userByChatId.isPresent()) {
            User user = userByChatId.get();
            UserStateDTO userStateDTO = new UserStateDTO(user.getChatId(), user.getState());
            return new BaseResponse<>("success", 200, userStateDTO);
        }

        return new BaseResponse<>("fail", 404);
    }

    @Override
    public void updateState(UserStateDTO stateDTO) {
        userRepository.updateUserState(stateDTO.state(), stateDTO.chatId());
    }
}
