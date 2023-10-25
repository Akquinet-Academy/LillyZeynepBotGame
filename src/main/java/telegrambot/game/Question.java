package telegrambot.game;

import java.util.List;
import java.util.stream.Collectors;

public class Question {
  //  private String title;
    private String text;
    private int id;


    public Question(String text, int id) {
        this.text = text;
        this.id = id;
    }

    @Override
    public String toString() {
        return text;
    }
}
