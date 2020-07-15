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

import java.io.IOException;
import java.util.List;

public class Register implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length >= 2) {
                if (!PlayerDataConfig.pdata.contains("PlayerData."+p.getName().toLowerCase())) {
                    if (args[0].equals(args[1])) {
                        if (args[0].length() < Main.p.getConfig().getInt("max-password-length")) {
                            PlayerDataConfig.pdata.set("PlayerData."+p.getName().toLowerCase()+".Password",args[0]);
                            List<String> il = PlayerDataConfig.pdata.getStringList("Ip." + p.getAddress());
                            il.add(p.getName().toLowerCase());
                            PlayerDataConfig.pdata.set("Ip."+p.getAddress(), il);
                            try {
                                PlayerDataConfig.pdata.save(PlayerDataConfig.pdatac);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            LoginManager.lm.add(p);
                            sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.getString("register")));
                            if (p.getGameMode()== GameMode.CREATIVE) {
                                p.setAllowFlight(true);
                            }else if (p.getGameMode()==GameMode.SPECTATOR) {
                                p.setAllowFlight(true);
                            }else {
                                p.setAllowFlight(false);
                            }
                        }else {
                            String max = String.valueOf(Main.p.getConfig().getInt("max-password-length"));
                            sender.sendMessage(GLib.convertColorSymbols(LangConfig.lang.getString("prefix")+LangConfig.getString("password-length-limit-exceeded").replace("{1}",max)));
                        }
                    }else {
                        sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix")+LangConfig.getString("two-password-inconsistency")));
                    }
                }else {
                    sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix")+LangConfig.getString("already-registered")));
                }
            }else {
                sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix")+LangConfig.getString("no-enough-args")));
            }
        }else {
            sender.sendMessage(GLib.convertColorSymbols(LangConfig.getString("prefix")+LangConfig.getString("only-player")));
        }
        return true;

    }
}
