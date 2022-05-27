package me.theboykiss.ovh.cryjoinmessage.Events;

import me.theboykiss.ovh.cryjoinmessage.CryJoinMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEvents implements Listener {
    private CryJoinMessage plugin;
    public JoinEvents(CryJoinMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Join2(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String messageFromConfig = plugin.getConfig().getString("join-message");
        if (messageFromConfig.contains("%playername%")) {
            messageFromConfig = messageFromConfig.replace("%playername%", p.getName());
        }
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', messageFromConfig));
        p.sendTitle(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("title-join")), ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("subtitle-join")), 1, plugin.getConfig().getInt("duration-title"), 1);
        p.playSound(p.getLocation(), Sound.valueOf(plugin.getConfig().getString("sound-join")), 5, 5);
        p.setHealthScale(plugin.getConfig().getInt("healthscale"));
        e.setJoinMessage("");
    }

    @EventHandler
    public void Leave2(PlayerQuitEvent e){
        Player p = e.getPlayer();
        String messageFromConfig = plugin.getConfig().getString("leave-message");
        if (messageFromConfig.contains("%playername%")) {
            messageFromConfig = messageFromConfig.replace("%playername%", p.getName());
        }
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', messageFromConfig));
        e.setQuitMessage("");
    }
}
