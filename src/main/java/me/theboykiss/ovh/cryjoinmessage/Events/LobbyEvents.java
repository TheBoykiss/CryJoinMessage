package me.theboykiss.ovh.cryjoinmessage.Events;

import me.theboykiss.ovh.cryjoinmessage.CryJoinMessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;

public class LobbyEvents implements Listener {
    private CryJoinMessage plugin;

    public LobbyEvents(CryJoinMessage plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Player) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void blockBreak(BlockBreakEvent e){
        if (e.getPlayer().hasPermission("cryjoin.break")){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void blockPlace(BlockPlaceEvent e){
        if (e.getPlayer().hasPermission("cryjoin.place")){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.setFormat(ChatColor.translateAlternateColorCodes('&', "&a"+ p.getName() + "&7:&f "+ e.getMessage()));
    }
    @EventHandler
    public void foodChange(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }
}
