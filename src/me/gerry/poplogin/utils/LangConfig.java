package me.gerry.poplogin.utils;

import me.gerry.library.GLib;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangConfig {
    public static File langc=new File("plugins/PopLogin","lang.yml");
    public static FileConfiguration lang= YamlConfiguration.loadConfiguration(langc);
    public static String getString(String path) {
        String s = GLib.convertColorSymbols((lang.getString(path)));
        return s;
    }
    public static void reload() {
        try {
            lang.load(langc);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
