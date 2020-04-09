package lito773.deathcounter.events;

import lito773.deathcounter.io.Counter;
import lito773.deathcounter.io.Messages;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EventsClass implements Listener {
    Counter c;
    Messages m;

    public EventsClass(Counter c, Messages m) {
        this.c = c;
        this.m = m;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        String player = event.getEntity().getDisplayName();

        int numOfDeaths = c.incrementDeath(player);

        m.broadcastDeath(numOfDeaths, player);
    }
}
