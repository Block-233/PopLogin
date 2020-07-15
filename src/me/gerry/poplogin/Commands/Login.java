package me.gerry.poplogin.Commands;

import me.gerry.library.GLib;
import me.gerry.poplogin.Main;
import me.gerry.poplogin.utils.LangConfig;
import me.gerry.poplogin.utils.LoginManager;
import me.gerry.poplogin.utils.PlayerDataConfig;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Login implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length >= 1) {
            if (PlayerDataConfig.pdata.contains("PlayerData."+p.getName().toLowerCase())) {
                    String name = p.getName().toLowerCase();
                    if (args[0].equals(PlayerDataConfig.pdata.getString("PlayerData."+name+".Password"))) {
                        LoginManager.lm.add(p);
                        p.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("login")));
                        if (p.getGameMode()==GameMode.CREATIVE) {
                            p.setAllowFlight(true);
                        }else if (p.getGameMode()==GameMode.SPECTATOR) {
                            p.setAllowFlight(true);
                        }else {
                            p.setAllowFlight(false);
                        }
                    }else {
                        if (!Main.p.getConfig().getBoolean("password-wrong-kick")) {
                            sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.get("password-wrong")));
                        }else {
                            p.kickPlayer(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.get("password-wrong")));
                        }
                    }
                }else {
                sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("not-register")));
                }
            }else {
                sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("no-enough-args")));
            }
        }else {
            sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.lang.getString("only-player")));
        }
        return true;
    }


}
