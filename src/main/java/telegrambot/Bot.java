package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.game.Game;

import java.io.File;
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
            sendMessage(chatId, "Type 'ready' if you are ready! ☺",false);
        }

        if (messageReceived.toLowerCase().equals("ready")) {
            sendMessage(chatId, "Here we go!", false);
            sendMessage(chatId, "You will need to rate each question from 1 to 5.",false);
            sendMessage(chatId, "Use the custom keyboard to do so!",false);
            game = new Game();
            sendSticker(chatId, "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\bamdumtis.tgs", false);
            sendAudio(chatId, "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\drumroll.mp3");
            sendQuestion(chatId, game.getQuestion().toString(), true);
        } else if(messageReceived.equals("1") ||
                  messageReceived.equals("2") ||
                  messageReceived.equals("3") ||
                  messageReceived.equals("4") ||
                  messageReceived.equals("5")
        ) {
            if (game.getIndex() < 9) {
                delegateTheUserAnswerToItsVariable((game.getIndex()), Integer.parseInt(messageReceived));
                sendQuestion(chatId, game.getQuestion().toString(), false);
            } else if (game.getIndex() == 9) {
                delegateTheUserAnswerToItsVariable((game.getIndex()), Integer.parseInt(messageReceived));
                sendMessage(chatId, "Here it is! Meet the pet that effortlessly fits into your world!", false);
                sendMessage(chatId, "🥁 🥁 🥁", false);
                sendAudio(chatId, "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\drumroll.mp3");
                sendDrumroll(chatId);
                sendMessage(chatId, game.showWinningPet(cleaningScale, inactivityScale,
                        selfCenterednessScale, eatingLeftoversScale, eatingMeatScale,
                        prefersBeachHolidayScale, sensitivenessScale), true);
                sendSticker(chatId, game.getWinner().getStickerFilePath(), true);
                sendMessage(chatId, "If you want, you can feed, entertain, love or train your purrfect pet. \uD83C\uDF7D\uFE0F  \uD83C\uDFB6 ❤ \uD83D\uDCA1 ", true);
                sendMessage(chatId, "Use the custom keyboard again to do so!", true);

            }
        }
        sendMessage(chatId, "You can play with your pet as long as you want! If you want to end the game, please type 'end'", false);
        boolean end = false;
        if(messageReceived.equals("end")){
            end = true;
        }
        while(!end){
            sendPettingAudio(chatId, messageReceived);
        }

        if (!(messageReceived.toLowerCase().equals("ready") ||
                messageReceived.toLowerCase().startsWith("/start") ||
                messageReceived.equals("1") ||
                messageReceived.equals("2") ||
                messageReceived.equals("3") ||
                messageReceived.equals("4") ||
                messageReceived.equals("5")
                //add petting options
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
                        createCustomKeyboard(message);
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);

        } else {
            try {
                createCustomKeyboard(message);
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public void sendSticker(long chatId, String stickerPath, boolean t){
        boolean hasTimer = t;
        InputFile stickerFile = new InputFile(new File(stickerPath));
        SendSticker stickerMessage = new SendSticker(String.valueOf(chatId), stickerFile);

        if(hasTimer){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        execute(stickerMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);

        } else {
            try {
                execute(stickerMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendDrumroll(long chatId){

        String audioFilePath = "C:\\Users\\LillySeiffert\\development\\LillyZeynepBotGame\\src\\main\\resources\\audio\\drumroll-93348.mp3";

        InputFile audioDatei = new InputFile(new File(audioFilePath));
        SendAudio sendAudio = new SendAudio(String.valueOf(chatId), audioDatei);
        try {
            execute(sendAudio);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendAudio(long chatId, String audioFilePath){
        InputFile audioDatei = new InputFile(new File(audioFilePath));
        SendAudio sendAudioMessage = new SendAudio(String.valueOf(chatId), audioDatei);
        try {
            execute(sendAudioMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPettingAudio(long chatId, String messageReceived){
        InputFile audioDatei;
        if(messageReceived.equals("feed")){
            audioDatei = new InputFile(new File("C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\feed.mp3"));
        } else if(messageReceived.equals("entertain")){
            audioDatei = new InputFile(new File("C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\entertain.mp3"));
        } else if(messageReceived.equals("love")){
            audioDatei = new InputFile(new File("C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\love.mp3"));
        } else if(messageReceived.equals("train")){
            audioDatei = new InputFile(new File("C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\train.mp3"));
        } else {
            audioDatei = new InputFile(new File("C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\ehh.mp3"));
        }
        SendAudio sendAudioMessage = new SendAudio(String.valueOf(chatId), audioDatei);
        try {
            execute(sendAudioMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void sendQuestion(long chatId, String s, boolean t) {
        boolean hasTimer = t;
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(s);

        if(hasTimer){
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        createCustomKeyboard(message);
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }, 4000);

        } else {
            try {
                createCustomKeyboard(message);
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
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
        KeyboardRow row2 = new KeyboardRow();
        row2.add("feed");
        row2.add("entertain");
        row2.add("love");
        row2.add("train");
        keyboard.add(row);
        keyboard.add(row2);
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

