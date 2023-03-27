package org.example.repository.user;

import org.example.domain.model.User;
import org.example.domain.model.UserState;
import org.example.repository.BaseRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    String FIND_BY_CHAT_ID = "select * from users where chat_id = ?";

    String INSERT = """
            insert into users(full_name, phone_number, chat_id, user_state) 
            values(?, ?, ?, ?);
            """;

    String UPDATE_STATE = """
            update users set user_state = ? where chat_id = ?;
            """;

    Optional<User> findUserByChatId(String chatId);

    void updateUserState(UserState state,String chatId);
}
