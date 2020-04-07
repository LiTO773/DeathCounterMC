package lito773.deathcounter.io;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getLogger;

public class Messages {
    private File messagesFile;

    public Messages(File dataFolder) {
        messagesFile = new File(dataFolder + File.separator + "messages.txt");
        if (!messagesFile.exists()) {
            try {
                messagesFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().severe("UNABLE TO CREATE THE MESSAGES FILE");
            }
        }
    }
}
