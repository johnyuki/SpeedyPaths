package com.johnyuki.speedypaths;

import com.johnyuki.speedypaths.events.PlayerMove;
import com.johnyuki.speedypaths.commands.CommandManager;
import com.johnyuki.speedypaths.utils.VerifyConfig;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SpeedyPaths extends JavaPlugin {

    public static JavaPlugin plugin;
    public static final String pluginVersion = "2.0.0";

    @Override
    public void onEnable() {
        plugin = this;
        loadConfig();
        this.getCommand("speedypaths").setExecutor(new CommandManager());
        this.getServer().getPluginManager().registerEvents(new PlayerMove(), this);
        this.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[SpeedyPaths]" + ChatColor.WHITE + " Enabled!");
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "[SpeedyPaths]" + ChatColor.WHITE + " Disabled!");
    }

    public static void loadConfig() {
        VerifyConfig.checkConfigVersion();
        plugin.saveDefaultConfig();
    }
}