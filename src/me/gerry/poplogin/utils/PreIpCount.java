package me.gerry.poplogin.utils;

import me.gerry.poplogin.Main;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class PreIpCount {
    public static boolean check(Player p) {
        if (PlayerDataConfig.pdata.contains("Ip." + p.getAddress())) {
            if (PlayerDataConfig.pdata.getStringList("Ip." + p.getAddress()).size() < Main.p.getConfig().getInt("pre-ip-max-accounts-count")) {
                return true;
            } else {
                return false;
            }
        }else {
            return true;
        }
    }
    public static void add(Player p) {
        List<String> il = PlayerDataConfig.pdata.getStringList("Ip" + p.getAddress());
        il.add(p.getName().toLowerCase());
        PlayerDataConfig.pdata.set("Ip."+p.getAddress(),il);
        try {
            PlayerDataConfig.pdata.save(PlayerDataConfig.pdatac);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
