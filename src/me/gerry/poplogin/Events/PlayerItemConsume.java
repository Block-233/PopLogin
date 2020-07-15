package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerItemConsume implements Listener {
    @EventHandler
    public void ItemConsume(PlayerItemConsumeEvent e) {
        if (!LoginManager.lm.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
