package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlace implements Listener {
    @EventHandler
    public void Place(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!LoginManager.lm.contains(p)) {
            e.setCancelled(true);
        }
    }
}
