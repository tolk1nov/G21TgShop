package org.example.bot;

import org.example.domain.DTO.BaseResponse;
import org.example.domain.DTO.UserCreateDTO;
import org.example.domain.DTO.UserStateDTO;
import org.example.domain.model.UserState;
import org.example.service.user.UserService;
import org.example.service.user.UserServiceImpl;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ShopBotService {
    private final UserService userService = new UserServiceImpl();



    public SendMessage registerUser(String chatId, Contact contact){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        UserCreateDTO userCreateDTO = new UserCreateDTO(
                contact.getFirstName() + " " + contact.getLastName(),
                contact.getPhoneNumber(), chatId);
        BaseResponse response = userService.save(userCreateDTO);

        if(response.getStatus() == 200) {
            userService.updateState(new UserStateDTO(chatId, UserState.REGISTERED));
            sendMessage.setReplyMarkup(mainMenu());
        }

        sendMessage.setText(response.getMessage());
        return sendMessage;
    }

    public UserState checkState(String chatId) {
        BaseResponse<UserStateDTO> response = userService.getUserState(chatId);
        if(response.getStatus() == 200) {
            return response.getData().state();
        }
        return UserState.START;
    }

    public SendMessage shareContact(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, "Please register");
        sendMessage.setReplyMarkup(requestContact());
        return sendMessage;
    }


    public ReplyKeyboardMarkup requestContact() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        KeyboardRow keyboardRow = new KeyboardRow();
        KeyboardButton button = new KeyboardButton("Please share phone number 📞");
        button.setRequestContact(true);
        keyboardRow.add(button);

        markup.setResizeKeyboard(true);
        markup.setKeyboard(List.of(keyboardRow));
        return markup;
    }

    public ReplyKeyboardMarkup mainMenu() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow row = new KeyboardRow();
        row.add("\uD83D\uDCCB Categories");
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("\uD83D\uDCD1 Orders");
        keyboardRows.add(row);

        row = new KeyboardRow();
        row.add("\uD83D\uDED2 Basket");
        keyboardRows.add(row);

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        return replyKeyboardMarkup;
    }

}
