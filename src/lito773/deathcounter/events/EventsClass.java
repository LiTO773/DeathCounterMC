package lito773.deathcounter.events;

import lito773.deathcounter.io.Counter;
import lito773.deathcounter.io.Messages;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static org.bukkit.Bukkit.getLogger;

public class EventsClass implements Listener {
    Counter c;
    Messages m;

    public EventsClass(Counter c, Messages m) {
        this.c = c;
        this.m = m;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        c.incrementDeath(event.getEntity().getDisplayName());
        getLogger().info("AHAHAHAHA");
        Bukkit.broadcastMessage("AHAHAHAHAH NABO!");
    }
}
