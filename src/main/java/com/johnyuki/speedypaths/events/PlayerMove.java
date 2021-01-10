package com.johnyuki.speedypaths.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.johnyuki.speedypaths.SpeedyPaths;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Location location = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
        int duration = SpeedyPaths.plugin.getConfig().getInt("duration");
        int amplifier = SpeedyPaths.plugin.getConfig().getInt("level") - 1;
        if(player.hasPermission("speedypaths.use")) {
            if(location.getBlock().getType() == Material.GRASS_PATH) {
                if(player.getPotionEffect(PotionEffectType.SPEED) != null){
                    if(!SpeedyPaths.plugin.getConfig().getBoolean("remove-previous-speed-effect")){
                        if(player.getPotionEffect(PotionEffectType.SPEED).getAmplifier() == amplifier) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amplifier));
                        }
                    } else {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amplifier));
                    }
                } else {
                    player.removePotionEffect(PotionEffectType.SPEED);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, amplifier));
                }
            }
        }
    }
}