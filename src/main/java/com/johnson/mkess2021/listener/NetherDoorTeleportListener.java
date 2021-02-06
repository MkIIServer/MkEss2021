package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class NetherDoorTeleportListener extends MyListener {

    public NetherDoorTeleportListener(MkEss2021 instance) {
        super(instance);
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        if (
                e.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL &&
                        e.getTo().getWorld().getEnvironment() == World.Environment.NORMAL
        ) {
            Player p = e.getPlayer();
            plugin.netherdoor.setTeleportLocation(p, e.getFrom(), e.getTo());
        }
    }
}
