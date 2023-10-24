package telegrambot.game;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
  //  private String title;
    private String text;


    public Question(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
