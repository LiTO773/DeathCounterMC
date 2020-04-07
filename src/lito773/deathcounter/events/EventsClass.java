package lito773.deathcounter.events;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.getLogger;

public class EventsClass implements Listener {
    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        getLogger().info("AHAHAHAHA");
        Bukkit.broadcastMessage("AHAHAHAHAH NABO!");
    }
}
