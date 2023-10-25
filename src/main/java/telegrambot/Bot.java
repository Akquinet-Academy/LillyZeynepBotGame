package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Bot extends TelegramLongPollingBot {

    private Game game;
    private int cleaningScale = 0;
    private int inactivityScale = 0;
    private int selfCenterednessScale = 0;
    private int eatingLeftoversScale = 0;
    private int eatingMeatScale = 0;
    private int prefersBeachHolidayScale = 0;
    private int sensitivenessScale = 0;



    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        String messageReceived = update.getMessage().getText();

        if (messageReceived.toLowerCase().startsWith("/start")) {
            sendMessage(chatId, "Hello! Welcome pet lover!  \uD83D\uDC36\n", false);
            sendMessage(chatId, "Let's answer some questions to find the purrfect pet for you!",false);
            sendMessage(chatId, "Type 'ready' if you are ready!",false);
        }

        if (messageReceived.toLowerCase().equals("ready")) {
            sendMessage(chatId, "you will need to rate each question from 1 to 5.\n1 means 'not at all' and 5 'absolutely'", false);
            game = new Game();
            sendSticker(chatId, game.getPetsList().get("hund").getStickerFile());
            sendQuestion(chatId, game.getQuestion().toString());
        } else if(messageReceived.equals("1") ||
                  messageReceived.equals("2") ||
                  messageReceived.equals("3") ||
                  messageReceived.equals("4") ||
                  messageReceived.equals("5")
        ){
            if(game.getIndex() < 9){
                delegateTheUserAnswerToItsVariable((game.getIndex()),Integer.parseInt(messageReceived));
                sendQuestion(chatId, game.getQuestion().toString());
            } else if(game.getIndex() == 9){
                delegateTheUserAnswerToItsVariable((game.getIndex()),Integer.parseInt(messageReceived));
                sendMessage(chatId, "Here it is! Meet the pet that effortlessly fits into your world!", false);
                sendMessage(chatId, game.showWinningPet(cleaningScale, inactivityScale,
                        selfCenterednessScale, eatingLeftoversScale, eatingMeatScale,
                        prefersBeachHolidayScale, sensitivenessScale), true);
            }

        }
        if (!(messageReceived.toLowerCase().equals("ready") ||
                messageReceived.toLowerCase().startsWith("/start") ||
                messageReceived.equals("1") ||
                messageReceived.equals("2") ||
                messageReceived.equals("3") ||
                messageReceived.equals("4") ||
                messageReceived.equals("5")
                //change the condition so, so that it shows this answer at inappropriate options in this list as well??
             )
            )  {
            sendMessage(chatId, "That answer is not really purrfect!  \uD83D\uDC36\n", false);
        }
    }

    private void delegateTheUserAnswerToItsVariable(int keyOfQuestion, int answerOfUser){
        switch(keyOfQuestion){
            case 1:
                cleaningScale += answerOfUser;
            break;
            case 2,3 :
                inactivityScale += answerOfUser;
            break;
            case 4,6:
                selfCenterednessScale += answerOfUser;
            break;
            case 5:
                eatingLeftoversScale += answerOfUser;
            break;
            case 7:
                eatingMeatScale += answerOfUser;
            break;
            case 8:
                prefersBeachHolidayScale += answerOfUser;
            break;
            case 9:
                sensitivenessScale += answerOfUser;
            break;
        }
    }

    private void sendMessage(long chatId, String s, boolean t) {
        boolean hasTimer = t;
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);
        // msg.setReplyMarkup(null); this doesnt work, but we can use keyboard to pet the animals??

        if(hasTimer){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);

        } else {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public void sendSticker(long chatId, InputFile file){
        SendSticker stickerMessage = new SendSticker();
        // InputFile sticker = new InputFile("stickers/sticker.webp");
        stickerMessage.setChatId(chatId);
        stickerMessage.setSticker(file);
        try {
            execute(stickerMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendQuestion(long chatId, String s) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);

        try {
            createCustomKeyboard(message);
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createCustomKeyboard(SendMessage message){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("1");
        row.add("2");
        row.add("3");
        row.add("4");
        row.add("5");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(keyboardMarkup);
    }

    @Override
    public String getBotToken() {
        return "6663371100:AAGNoAWH0oW3l-U_OgvLoStKLu_zQ3vh4YY";  // TODO: insert your bot token here!
    }

    @Override
    public String getBotUsername() {
        return "PetWhispererBot";  // TODO: insert your bots username here
    }


}

