package lito773.deathcounter.io;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static org.bukkit.Bukkit.getLogger;

public class Messages {
    Random objGenerator;
    private List<String> messages;

    /**
     * The constructor will automatically check if the file exists. If it doesn't, it automatically creates the
     * messages.txt
     * @param dataFolder Plugin's data folder
     */
    public Messages(File dataFolder) {
        objGenerator = new Random();
        messages = new ArrayList<>();
        File messagesFile = new File(dataFolder + File.separator + "messages.txt");
        if (!messagesFile.exists()) {
            try {
                messagesFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                getLogger().severe("UNABLE TO CREATE THE MESSAGES FILE");
            }
        }

        try {
            loadMessages(messagesFile);
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("UNABLE TO PROPERLY READ THE MESSAGES FILE");
        }
    }

    /**
     * Reads the messages present in the text file and adds them to the Messages array
     * @param file Messages file
     */
    private void loadMessages(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        // Read each line
        String str;
        while ((str = br.readLine()) != null) {
            // Ignore all comments
            if (str.charAt(0) == '#') continue;

            // Get the colors and formatting
            str = str.replaceAll("%([0-9a-z])%", '\u00A7' + "$1");
            getLogger().info(str);

            // Add to the array
            messages.add(str);
        }
    }

    public void broadcastDeath(int numOfDeaths, String playerName) {
        // Get a random message
        int msgPos = objGenerator.nextInt(messages.size() - 1);

        // get the message and add the number of deaths and player name to the message
        String msgToSend = messages.get(msgPos);
        msgToSend = msgToSend.replace("%NUM%", Integer.toString(numOfDeaths));
        msgToSend = msgToSend.replace("%PLAYER%", playerName);

        Bukkit.broadcastMessage(msgToSend);
    }
}
