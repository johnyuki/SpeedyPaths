package com.johnyuki.speedypaths.utils;

import java.io.File;
import java.io.IOException;

import com.johnyuki.speedypaths.SpeedyPaths;
import net.md_5.bungee.api.ChatColor;

public class VerifyConfig {

    public static void checkConfigVersion() {
        String configVersion = SpeedyPaths.plugin.getConfig().getString("version", "1.0.0");
        if(!configVersion.equals(SpeedyPaths.pluginVersion)){
            SpeedyPaths.plugin.getServer().getConsoleSender().sendMessage(
                    ChatColor.YELLOW + "[SpeedyPaths] Your plugin version and config version do not match. Rename the " +
                            "current config file and let the plugin generate the updated config, and then copy and " +
                            "paste any necessary values from the old config.");
        }
    }

}