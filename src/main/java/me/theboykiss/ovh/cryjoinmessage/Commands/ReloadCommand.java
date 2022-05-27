package me.theboykiss.ovh.cryjoinmessage.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class ReloadCommand implements CommandExecutor {

    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("CryJoinMessage");
    final FileConfiguration config = plugin.getConfig();
    PluginDescriptionFile pdfFile = plugin.getDescription();
    public String version = pdfFile.getVersion();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")){
            if (sender.hasPermission("cryjoin.reload")){
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("reload-command-success")));
                plugin.saveConfig();
                return true;
            }else{
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("reload-command-nopermission")));
                return true;
            }
        }else{
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lCRYJOIN &eThe server is using CryJoin with Version &6v" + pdfFile.getVersion()  + "&e Created by &6TheBoykissOld"));
        }
        return true;
    }
}
