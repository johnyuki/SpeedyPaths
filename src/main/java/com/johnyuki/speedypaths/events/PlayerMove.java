package com.johnyuki.speedypaths.events;

import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.johnyuki.speedypaths.SpeedyPaths;

import java.util.List;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int duration = SpeedyPaths.plugin.getConfig().getInt("duration", 20);
        int amplifier = SpeedyPaths.plugin.getConfig().getInt("level", 1) - 1;
        if(player.hasPermission("speedypaths.use")) {
            String currentBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().toString();
            List<String> blockList = SpeedyPaths.plugin.getConfig().getStringList("blocks");
            if(blockList.contains(currentBlock)) {
                if(player.getPotionEffect(PotionEffectType.SPEED) != null){
                    if(!SpeedyPaths.plugin.getConfig().getBoolean("remove-previous-speed-effect", false)){
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