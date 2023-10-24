package telegrambot.game;

import java.util.List;
import java.util.Random;

public class Game {
    private List<Question> questionsList = this.initQuestions();
    private List<Pet> petsList = this.initPets();
    private int index = 0;

    public Game() {
    }

    private List<Question> initQuestions() {
        return List.of(new Question("Do you find cleaning your apartment to be a thrill ride?"),
                new Question("How well does \"live fast, die young\" resonate with your life philosophy?"),
                new Question("Would you proudly wear the badge of a certified couch potato?"),
                new Question("Are you as stubborn as a mule?"),
                new Question("Is leftover food your secret weapon against intergalactic invaders?"),
                new Question("In a heated discussion, do you fight tooth and nail to be the reigning champ of rightness?"),
                new Question("Do you enjoy a meaty feast?"),
                new Question("How do you feel about a holiday basking in the sun and splashing in the waves?"),
                new Question("On average, how many mental breakdances do you treat yourself to in a week?")
        );
    }

    private List<Pet> initPets(){
        return List.of(new Pet("Katze", "Katzesticker"));
    }

    public List<Pet> getPetsList() {
        return petsList;
    }

    /*
    public boolean addQuestion(Question q) {
        return this.questionsList.add(q);
    }*/

    public int getIndex() {
        return index;
    }

    public Question getQuestion() {
        return (Question) this.questionsList.get(index++);
    }

    public String showPet(){
        return petsList.get(0) ;
    }
}

