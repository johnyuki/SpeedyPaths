package com.johnyuki.speedypaths.utils;

import java.io.File;
import java.io.IOException;

import com.johnyuki.speedypaths.SpeedyPaths;
import net.md_5.bungee.api.ChatColor;

public class VerifyConfig {

    public static boolean verifyConfig() {
        boolean verified = true;
        if(SpeedyPaths.plugin.getConfig().getInt("level") < 1) {
            verified = false;
        }
        try {
            int num = Integer.parseInt(SpeedyPaths.plugin.getConfig().getString("duration"));
            if(num < 0) {
                throw new NumberFormatException("Negative number.");
            }
        } catch (NumberFormatException nfe){
            verified = false;
        }
        String bool = SpeedyPaths.plugin.getConfig().getString("remove-previous-speed-effect");
        if(!bool.equals("true") && !bool.equals("false")) {
            verified = false;
        }

        if(verified) {
            SpeedyPaths.plugin.getServer().getConsoleSender().sendMessage(
                    ChatColor.GREEN + "[SpeedyPaths] " + ChatColor.WHITE + "Config valid");
            return true;
        } else {
            File config = new File(SpeedyPaths.plugin.getDataFolder()+ "/config.yml");
            config.delete();
            SpeedyPaths.loadConfig();
            SpeedyPaths.plugin.getServer().getConsoleSender().sendMessage(
                    ChatColor.YELLOW + "[SpeedyPaths] " + ChatColor.WHITE + "Invalid config. Config deleted and default config loaded.");
            return false;
        }
    }

}