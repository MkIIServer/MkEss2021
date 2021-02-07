package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WitherSpawnListener extends MyListener{
    public WitherSpawnListener(MkEss2021 instance) {
        super(instance);
    }

    @EventHandler
    public void onCreateSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getType() == EntityType.WITHER) {
            Location location = event.getLocation();
            double X = location.getX();
            double Y = location.getY();
            double Z = location.getZ();

            Bukkit.broadcastMessage("凋零怪在座標:" + " X: " + X + " Y: " + Y + " Z: " + Z + " 被招喚" );
        }
    }
}
