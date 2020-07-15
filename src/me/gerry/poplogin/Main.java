package me.gerry.poplogin;

import me.gerry.library.GLib;
import me.gerry.poplogin.Commands.*;
import me.gerry.poplogin.Events.*;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Plugin p;
    @Override
    public void onEnable() {
        p = this;
        saveDefaultConfig();
        saveResource("lang.yml",false);
        saveResource("playerdata.yml",false);
        GLib.sendColoredMessage("&8[&cPopLogin&8] &aLoading plugin...");
        GLib.sendColoredMessage("&8[&cPopLogin&8] &e"+Bukkit.getVersion());
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerJoin(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerMove(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerChat(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerAnimation(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerBedEnter(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerBreak(),this);
        //Bukkit.getPluginManager().registerEvents((Listener) new PlayerBucket(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerDamage(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerDropItem(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerFish(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerGameModeChange(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerInteractEntity(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerItemConsume(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerPickupItem(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerPickupArrow(),this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlayerPlace(),this);
        Bukkit.getPluginCommand("login").setExecutor(new Login());
        Bukkit.getPluginCommand("poplogin").setExecutor(new Poplogin());
        Bukkit.getPluginCommand("register").setExecutor(new Register());
        Bukkit.getPluginCommand("unlogin").setExecutor(new Unlogin());
        Bukkit.getPluginCommand("loginstate").setExecutor(new Loginstate());
        GLib.sendColoredMessage("&8[&cPopLogin&8] &aPlugin loaded! :D");

    }
    @Override
    public void onDisable() {
        GLib.sendColoredMessage("&8[&cPopLogin&8] &cUnloading plugin...");
        GLib.sendColoredMessage("&8[&cPopLogin&8] &aPlugin unloaded. Thanks for using! ;)");
    }
}
