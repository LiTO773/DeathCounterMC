package lito773.deathcounter.io;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getLogger;

public class Counter {
    public static void checkFile(File dataFolder) {
        File file = new File(dataFolder + File.separator + "counter.yml");
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
