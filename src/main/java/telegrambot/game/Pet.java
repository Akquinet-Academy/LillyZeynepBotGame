package telegrambot.game;

import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.stickers.InputSticker;

public class Pet {

    private String name;

    private InputFile stickerFile;

    public Pet(String name, InputFile stickerFile) {
        this.name = name;
        this.stickerFile = stickerFile;
        // add for each total 6 stickers - 5 to interact with 1 to show at the beginning;
    }

    public String getName() {
        return name;
    }

    public InputFile getStickerFile() {
        return stickerFile;
    }
}
