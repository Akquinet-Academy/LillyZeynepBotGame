package telegrambot.game;

import org.telegram.telegrambots.meta.api.objects.InputFile;
import telegrambot.Bot;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    private List<Question> questionsList = this.initQuestions();
    private Map<String, Pet> petsList = this.initPets();
    private int index = 0;

    private InputFile file; //holds the actual sticker File;

    public Game() {
    }

    private List<Question> initQuestions() {
        return List.of(new Question("Do you find cleaning your apartment to be a thrill ride?", 1),
                new Question("Would you like to live in a parallel world where time flows at half the speed?",2),
                new Question("Would you proudly wear the badge of a certified couch potato?",3),
                new Question("Are you as stubborn as a mule?",4),
                new Question("Is leftover food your secret weapon against intergalactic invaders?",5),
                new Question("In a heated discussion, do you fight tooth and nail to be the reigning champ of rightness?",6),
                new Question("Do you enjoy a meaty feast?",7),
                new Question("How do you feel about a holiday basking in the sun and splashing in the waves?",8),
                new Question("On average, how many mental breakdances do you treat yourself to in a week?", 9)
        );
    }

    private Map<String, Pet> initPets(){
        return Map.of("katze", new Pet("Katze",  new InputFile("stickers/sticker.webp")),
                "hund", new Pet("hund",  new InputFile("stickers/sticker.webp")));
        // add others as well
    }


    public int getIndex() {
        return index;
    }

    public Question getQuestion() {
        return (Question) this.questionsList.get(index++);
    }

    public Map<String, Pet> getPetsList() {
        return petsList;
    }

    public String showWinningPet(int cleaningScale,
                                 int inactivityScale,
                                 int selfCenterednessScale,
                                 int eatingLeftoversScale,
                                 int eatingMeatScale,
                                 int prefersBeachHolidayScale,
                                 int sensitivenessScale){

        if(sensitivenessScale == 5){
            return "Chaos-Chamäleon";
        } else {
            if(cleaningScale > 2){
                if(inactivityScale >= 9){
                    return "Faultier";
                }
                if(selfCenterednessScale >= 9){
                    return "Ziege";
                }
                if(inactivityScale < 9 && selfCenterednessScale < 9 && eatingMeatScale > 2){
                    return "katze";
                } else {
                    return "lama";
                }

            } else{
                if(eatingLeftoversScale > 4){
                    return "Schwein";
                }
                if(prefersBeachHolidayScale > 2 && eatingMeatScale > 2 && eatingLeftoversScale == 4){
                    return "krokodil";
                } else if(prefersBeachHolidayScale < 3 && eatingMeatScale < 3){
                    return "schildkröte";
                } else {
                    return "pinguin";
                }
            }
        }
    }
}

