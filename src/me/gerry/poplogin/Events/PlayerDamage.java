package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import net.minecraft.server.v1_16_R1.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEditBookEvent;

public class PlayerDamage implements Listener {
    @EventHandler
    public void Damage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!LoginManager.lm.contains(p)) {
                e.setCancelled(true);
            }
        }
    }
}
