package lito773.deathcounter.io;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

import static org.bukkit.Bukkit.getLogger;

public class Messages {
    public static void checkFile(File dataFolder) {
        File file = new File(dataFolder + File.separator + "messages.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().severe("UNABLE TO CREATE THE COUNTER FILE");
            }
        }
    }
}
