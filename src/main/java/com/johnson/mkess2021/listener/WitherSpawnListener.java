package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WitherSpawnListener extends MyListener{
    public WitherSpawnListener(MkEss2021 instance) {
        super(instance);
    }
    String WORLD = "";

    @EventHandler
    public void onCreateSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getType() == EntityType.WITHER) {
            Location location = event.getLocation();
            String world = event.getEntity().getWorld().getName();
            if (world.equals("world")){
                WORLD = "生存";
            }
            else if ( world.equals("world_nether")){
                WORLD = "地域";
            }
            else if ( world.equals("world_the_end")){
                WORLD = "終界";
            }
            double X = location.getX();
            double Y = location.getY();
            double Z = location.getZ();

            Bukkit.broadcastMessage( "凋零怪在座標:" + " X: " + X + " Y: " + Y + " Z: " + Z + " 被招喚" + " 世界: " + WORLD );
        }
    }
}
