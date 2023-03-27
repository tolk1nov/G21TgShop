package org.example.bot;

import lombok.SneakyThrows;
import org.example.domain.model.UserState;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ShopBot extends TelegramLongPollingBot {
    ShopBotService botService = new ShopBotService();

    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();
            String text = message.getText();

            UserState userState = botService.checkState(chatId);

            switch (userState){
                case START -> {
                    if(message.hasContact()) {
                        execute(botService.registerUser(chatId, message.getContact()));
                    } else {
                        execute(botService.shareContact(chatId));
                    }
                }
            }
        }
        else if(update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            Message message = callbackQuery.getMessage();
            String data = callbackQuery.getData();

        }

    }
}
