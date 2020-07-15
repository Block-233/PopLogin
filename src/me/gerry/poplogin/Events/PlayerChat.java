package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void Chat(AsyncPlayerChatEvent e) {
        if (!LoginManager.lm.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
}
