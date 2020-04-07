package lito773.deathcounter;

import lito773.deathcounter.events.EventsClass;
import lito773.deathcounter.io.Counter;
import lito773.deathcounter.io.Messages;
import org.bukkit.Bukkit;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        super.onEnable();

        // Creates the necessary files
        Counter c = new Counter(getDataFolder());
        Messages m = new Messages(getDataFolder());

        getLogger().info("Death Counter started!");
        getServer().getPluginManager().registerEvents(new EventsClass(c, m), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("Death Counter stopped!");
    }
}
