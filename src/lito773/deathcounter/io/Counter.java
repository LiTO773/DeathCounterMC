package lito773.deathcounter.io;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getLogger;

public class Counter {
    private File file;
    private FileConfiguration counterFile;

    public Counter(File dataFolder) {
        file = new File(dataFolder + File.separator + "counter.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().severe("UNABLE TO CREATE THE COUNTER FILE");
            }
        }
        counterFile = YamlConfiguration.loadConfiguration(file);
    }

    public void incrementDeath(String playerName) {
        // Increment
        int currentDeaths = counterFile.getInt(playerName);
        currentDeaths++;
        counterFile.set(playerName, currentDeaths);

        // Save the file
        try {
            counterFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("UNABLE TO SAVE THE COUNTER FILE");
        }
    }
}
