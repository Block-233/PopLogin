package me.gerry.poplogin.Commands;

import me.gerry.library.GLib;
import me.gerry.poplogin.utils.LangConfig;
import me.gerry.poplogin.utils.LoginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Loginstate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (LoginManager.lm.contains(p)) {
                p.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("login-state")));
            }else {
                p.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("notlogin-state")));
            }
        }else {
            sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("only-player")));
        }
        return true;
    }
}
