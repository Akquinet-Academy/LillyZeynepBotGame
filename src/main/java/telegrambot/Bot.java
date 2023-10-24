package telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegrambot.game.Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bot extends TelegramLongPollingBot {

    private Game q;

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();
        String messageReceived = update.getMessage().getText();
        // System.out.println(messageReceived);

        // start to evaluate the messages you received
        // 1. Main menu

        if (messageReceived.toLowerCase().startsWith("/start")) {
            sendQuestions(chatId, "Hello! Welcome pet lover!  \uD83D\uDC36\n");
            sendQuestions(chatId, "Let's answer some questions to find the purrfect pet for you!");
            sendQuestions(chatId, "Type 'ready' if you are ready!");

        }

        // 2. quiz mode
        if (messageReceived.toLowerCase().startsWith("ready")) {
            sendQuestions(chatId, "you will need to rate each question from 1 to 10. 1 means 'not at all' and 10 'absolutely'");
            q = new Game();
            sendQuestions(chatId, q.getQuestion().toString());
        } else if(messageReceived.toLowerCase().startsWith("1") ||
                  messageReceived.toLowerCase().startsWith("2") ||
                  messageReceived.toLowerCase().startsWith("3") ||
                  messageReceived.toLowerCase().startsWith("4") ||
                  messageReceived.toLowerCase().startsWith("5")
        ){
            if(q.getIndex() < 9){
                sendQuestions(chatId, q.getQuestion().toString());
            } else if(q.getIndex() == 9){
                // methode aufrufen, die resultat zeugt
            }

        }
        if (!(messageReceived.toLowerCase().startsWith("ready") ||
                messageReceived.toLowerCase().startsWith("/start") ||
                messageReceived.toLowerCase().startsWith("1") ||
                messageReceived.toLowerCase().startsWith("2") ||
                messageReceived.toLowerCase().startsWith("3") ||
                messageReceived.toLowerCase().startsWith("4") ||
                messageReceived.toLowerCase().startsWith("5")
             )
            )  {
            sendQuestions(chatId, "That answer is not really purrfect!  \uD83D\uDC36\n");
        }
        /*
        // 3. create a poll
        if (messageReceived.toLowerCase().startsWith("poll")) {
            sendPollToUser(chatId);
        }*/


    }


    private void sendQuestions(long chatId, String s) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText(s);

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void


    /*
    private void sendPollToUser(long chatId) {
        SendPoll sendPoll = new SendPoll();
        sendPoll.setChatId(chatId);
        sendPoll.setQuestion("Which programming language do you like the most?");
        sendPoll.setOptions(List.of("Java", "Python", "JavaScript", "C++"));
        try {
            execute(sendPoll);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public String getBotToken() {
        return "6663371100:AAGNoAWH0oW3l-U_OgvLoStKLu_zQ3vh4YY";  // TODO: insert your bot token here!
    }

    @Override
    public String getBotUsername() {
        return "PetWhispererBot";  // TODO: insert your bots username here
    }


}

