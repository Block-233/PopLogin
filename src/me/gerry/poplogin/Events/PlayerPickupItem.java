package me.gerry.poplogin.Events;

import me.gerry.poplogin.utils.LoginManager;
import net.minecraft.server.v1_16_R1.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class PlayerPickupItem implements Listener {
    @EventHandler
    public void PickupItem(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!LoginManager.lm.contains(p)) {
                e.setCancelled(true);
            }
        }
    }
}
