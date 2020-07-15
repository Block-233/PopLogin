package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupArrowEvent;

public class PlayerPickupArrow implements Listener {
    @EventHandler
    public void PickupArrow(PlayerPickupArrowEvent e) {
        if (!LoginManager.lm.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
