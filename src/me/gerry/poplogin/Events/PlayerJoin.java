package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LangConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void Join(PlayerJoinEvent e) {
        e.getPlayer().setAllowFlight(true);
        e.getPlayer().sendMessage(LangConfig.getString("prefix")+LangConfig.getString("login-tips"));
    }
}
