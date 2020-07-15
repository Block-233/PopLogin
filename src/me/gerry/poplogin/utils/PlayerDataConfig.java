package me.gerry.poplogin.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerDataConfig {
    public static File pdatac=new File("plugins/PopLogin","playerdata.yml");
    public static FileConfiguration pdata= YamlConfiguration.loadConfiguration(pdatac);
    public static void reload() {
        try {
            pdata.load(pdatac);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
