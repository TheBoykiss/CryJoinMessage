package me.theboykiss.ovh.cryjoinmessage;

import me.theboykiss.ovh.cryjoinmessage.Commands.ReloadCommand;
import me.theboykiss.ovh.cryjoinmessage.Events.JoinEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CryJoinMessage extends JavaPlugin {
    PluginDescriptionFile pdfFile = getDescription();
    public String version = pdfFile.getVersion();
    public String rutaConfig;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&aThank you for using my CryJoinMessage Plugin."));
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&6"+ pdfFile.getName() + " &ev " + pdfFile.getVersion()));
        registerConfig();
        getServer().getPluginManager().registerEvents(new JoinEvents(this), this);
        this.getCommand("cryjoin").setExecutor(new ReloadCommand());
    }

    public void registerConfig() {
        File config = new File(this.getDataFolder(),"config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
