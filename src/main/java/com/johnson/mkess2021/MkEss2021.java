package com.johnson.mkess2021;


import com.johnson.mkess2021.listener.*;
import com.johnson.mkess2021.schedule.NetherDoorTeleport;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MkEss2021 extends JavaPlugin {
    static JavaPlugin instance;
    public NetherDoorTeleport netherdoor;

    @Override
    public void onEnable() {
        // Plugin startup logic

        new SpeedElytraLimitListener(this);
        new NetherDoorTeleportListener(this);
        new ShulkerBoxLimitListener(this);
        new WitherSpawnListener(this);
        new ChatListener(this);
        new PlayerJoinListener(this);
        new PlayerDeathListener(this);

        netherdoor = new NetherDoorTeleport(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll();
    }



}
