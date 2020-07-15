package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener {
    @EventHandler
    public void DropItem(PlayerDropItemEvent e) {
        if (!LoginManager.lm.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
