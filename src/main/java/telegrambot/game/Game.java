package telegrambot.game;

import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import telegrambot.Bot;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {
    private List<Question> questionsList = this.initQuestions();
    private Map<String, Pet> petsList = this.initPets();
    private int index = 0;

    private Pet winner;

    public Game() {
    }

    private List<Question> initQuestions() {
        return List.of(new Question("Do you find cleaning your apartment to be a thrill ride? \uD83E\uDDF9\uD83E\uDEA3\uD83E\uDDFC", 1),
                new Question("Would you like to live in a parallel world where time flows at half the speed? \uD83E\uDE90",2),
                new Question("Would you proudly wear the badge of a certified couch potato? \uD83D\uDECB\uD83E\uDD54",3),
                new Question("Are you as stubborn as a mule? \uD83D\uDC34",4),
                new Question("Is leftover food your secret weapon against intergalactic invaders? \uD83C\uDF55\uD83C\uDF5D",5),
                new Question("In a heated discussion, do you fight tooth and nail to be the reigning champ of rightness? \uD83E\uDD77",6),
                new Question("Do you enjoy a meaty feast? \uD83E\uDD69\uD83C\uDF57",7),
                new Question("How do you feel about a holiday basking in the sun and splashing in the waves? \uD83C\uDF0A\uD83C\uDFD6",8),
                new Question("On average, how many mental breakdances do you treat yourself to in a week? \uD83D\uDE02\uD83D\uDE2D", 9)
        );
    }

    private Map<String, Pet> initPets(){
        return Map.of("chameleon", new Pet("Chaos Chameleon",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\chameleon\\chameleon-first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\chamelion.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\chameleon\\chameleon-feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\chameleon\\chameleon-entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\chameleon\\chameleon-love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\chameleon\\chameleon-train.tgs"),
                        "sloth", new Pet("RambaZamba Sloth",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\sloth\\sloth.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\sloth.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\sloth\\sloth.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\sloth\\sloth.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\sloth\\sloth.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\sloth\\sloth.train.tgs"),
                        "goat", new Pet("Grumbling Goat",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\goat\\goat.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\goat.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\goat\\goat.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\goat\\goat.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\goat\\goat.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\goat\\goat.train.tgs"),
                        "crocodile", new Pet("Schnappi the Crocodile",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\crocodile\\crocodile.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\crocodile.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\crocodile\\crocodile.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\crocodile\\crocodile.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\crocodile\\crocodile.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\crocodile\\crocodile.train.tgs"),
                        "penguin", new Pet("Paradise Penguin",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\penguin\\penguin.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\penguin.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\penguin\\penguin.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\penguin\\penguin.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\penguin\\penguin.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\penguin\\penguin.train.tgs"),
                        "cat", new Pet("Queen Cat",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\cat\\cat.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\cat.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\cat\\cat.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\cat\\cat.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\cat\\cat.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\cat\\cat.train.tgs"),
                        "llama", new Pet("Laughing Llama",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\llama\\llama.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\llama.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\llama\\llama.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\llama\\llama.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\llama\\llama.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\llama\\llama.train.tgs"),
                        "piglet", new Pet("Frederick Piglet",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\piglet\\piglet.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\piglet.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\piglet\\piglet.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\piglet\\piglet.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\piglet\\piglet.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\piglet\\piglet.train.tgs"),
                        "turtle", new Pet("Turbo Turtle",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\turtle\\turtle.first.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\audio\\turtle.mp3",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\turtle\\turtle.feed.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\turtle\\turtle.entertain.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\turtle\\turtle.love.tgs",
                        "C:\\Users\\ZeynepDerin\\IdeaProjects\\LillyZeynepBotGame\\src\\main\\resources\\stickers\\turtle\\turtle.train.tgs"));
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

    public Pet getWinner() {
        return winner;
    }

    public String showWinningPet(int cleaningScale,
                                 int inactivityScale,
                                 int selfCenterednessScale,
                                 int eatingLeftoversScale,
                                 int eatingMeatScale,
                                 int prefersBeachHolidayScale,
                                 int sensitivenessScale){

        if(sensitivenessScale == 5){
            winner = petsList.get("chameleon");
            return winner.getName();
        } else {
            if(cleaningScale > 2){
                if(inactivityScale >= 8){
                    winner = petsList.get("sloth");
                    return winner.getName();
                }
                if(selfCenterednessScale >= 9){
                    winner = petsList.get("goat");
                    return winner.getName();
                }
                if(eatingMeatScale > 3){
                    winner = petsList.get("cat");
                    return winner.getName();
                } else {
                    winner = petsList.get("llama");
                    return winner.getName();
                }

            } else{
                if(eatingLeftoversScale > 4){
                    winner = petsList.get("piglet");
                    return winner.getName();
                }
                if(prefersBeachHolidayScale > 2 && eatingMeatScale > 2 && (eatingLeftoversScale == 4 || eatingLeftoversScale ==3)){
                    winner = petsList.get("crocodile");
                    return winner.getName();
                } else if(prefersBeachHolidayScale < 3 && eatingMeatScale < 3){
                    winner = petsList.get("turtle");
                    return  winner.getName();
                } else {
                    winner = petsList.get("penguin");
                    return winner.getName();
                }
            }
        }
    }
}

