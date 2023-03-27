package org.example.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.model.UserState;

public record UserStateDTO(String chatId, UserState state) {
}

//@AllArgsConstructor
//@Getter
//public class UserStateDTO {
//    private final String chatId;
//    private final UserState state;
//
//}

