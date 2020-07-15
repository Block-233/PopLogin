package me.gerry.poplogin.Commands;

import me.gerry.library.GLib;
import me.gerry.poplogin.Main;
import me.gerry.poplogin.utils.LangConfig;
import me.gerry.poplogin.utils.PlayerDataConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Poplogin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                LangConfig.reload();
                PlayerDataConfig.reload();
                Main.p.reloadConfig();
                sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix") + LangConfig.getString("reload")));
            } else if (args[0].equalsIgnoreCase("help")) {
                int size = LangConfig.lang.getStringList("help-message").size();
                for (int cs = 0; cs < size; cs++) {
                    sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getStringList("help-message").get(cs)));
                }
            } else {
                sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix") + LangConfig.lang.getString("not-this-arg")));
            }
        }else {
            sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix")+LangConfig.getString("no-enough-args")));
        }
        return true;
    }

}
