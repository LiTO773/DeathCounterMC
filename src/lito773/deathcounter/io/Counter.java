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

    /**
     * The constructor will automatically check if the file exists. If it doesn't, it automatically creates the
     * counter.yml
     * @param dataFolder Plugin's data folder
     */
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

    /**
     * Evoked when a player dies. It will increment the number of deaths registered.
     * @param playerName Name of the player that died
     * @return Number of times the player has died
     */
    public int incrementDeath(String playerName) {
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

        return currentDeaths;
    }
}
