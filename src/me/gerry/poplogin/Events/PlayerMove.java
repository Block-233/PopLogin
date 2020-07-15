package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    @EventHandler
    public void Move(PlayerMoveEvent e) {
        if (!LoginManager.isLogin(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
