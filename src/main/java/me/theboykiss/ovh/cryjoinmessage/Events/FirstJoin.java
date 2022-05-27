package me.theboykiss.ovh.cryjoinmessage.Events;

import me.theboykiss.ovh.cryjoinmessage.CryJoinMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class FirstJoin implements Listener {
    private CryJoinMessage plugin;
    public FirstJoin(CryJoinMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Join2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String messageFromConfig = plugin.getConfig().getString("join-message");
        if (messageFromConfig.contains("%playername%")) {
            messageFromConfig = messageFromConfig.replace("%playername%", p.getName());
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', messageFromConfig));
        p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("sound-join")), 5, 5);
    }

    @EventHandler
    public void Leave2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String messageFromConfig = plugin.getConfig().getString("leave-message");
        if (messageFromConfig.contains("%playername%")) {
            messageFromConfig = messageFromConfig.replace("%playername%", p.getName());
        }
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', messageFromConfig));
        p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("sound-leave")), 5, 5);
    }
}
