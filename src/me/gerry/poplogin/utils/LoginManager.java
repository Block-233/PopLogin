package me.gerry.poplogin.utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class LoginManager {
    public static ArrayList<Player> lm = new ArrayList<Player>();
    public static boolean isLogin(Player player) {
        return lm.contains(player);
    }
}
