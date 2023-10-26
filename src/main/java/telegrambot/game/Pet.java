package telegrambot.game;

public class Pet {

    private String name;

    private String firstSticker;
    private String feedSticker;
    private String entertainSticker;
    private String loveSticker;
    private String trainSticker;

    private String audioDateiPath;

    public Pet(String name, String firstSticker, String audioDateiPath, String feedSticker,
               String entertainSticker, String loveSticker, String trainSticker) {
        this.name = name;
        this.firstSticker = firstSticker;
        this.audioDateiPath = audioDateiPath;
        this.feedSticker = feedSticker;
        this.entertainSticker = entertainSticker;
        this.loveSticker = loveSticker;
        this.trainSticker = trainSticker;
    }

    public String getName() {
        return name;
    }

    public String getFirstSticker() {
        return firstSticker;
    }

    public String getFeedSticker() {
        return feedSticker;
    }

    public String getEntertainSticker() {
        return entertainSticker;
    }

    public String getLoveSticker() {
        return loveSticker;
    }

    public String getTrainSticker() {
        return trainSticker;
    }

    public String getAudioDateiPath() {
        return audioDateiPath;
    }
}
