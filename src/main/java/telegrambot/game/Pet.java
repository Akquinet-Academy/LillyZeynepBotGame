package telegrambot.game;

public class Pet {

    private String name;

    private String stickerFilePath;

    private String audioDateiPath;

    public Pet(String name, String stickerFilePath, String audioDateiPath) {
        this.name = name;
        this.stickerFilePath = stickerFilePath;
        // add for each total 6 stickers - 5 to interact with 1 to show at the beginning;
        this.audioDateiPath = audioDateiPath;
    }

    public String getName() {
        return name;
    }

    public String getStickerFilePath() {
        return stickerFilePath;
    }

    public String getAudioDateiPath() {
        return audioDateiPath;
    }
}
