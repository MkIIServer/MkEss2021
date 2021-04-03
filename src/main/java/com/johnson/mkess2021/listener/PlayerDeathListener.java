package com.johnson.mkess2021.listener;


import com.SirBlobman.combatlogx.api.ICombatLogX;
import com.SirBlobman.combatlogx.api.utility.ICombatManager;
import com.johnson.mkess2021.MkEss2021;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener extends MyListener{
    public PlayerDeathListener(MkEss2021 instance){
        super(instance);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();

        if ( !(isInCombat(player))){
            event.setKeepInventory(true);
            event.getDrops().clear();
        }

    }

    public boolean isInCombat(Player player) {
        // You need to ensure that CombatLogX is enabled before using it for anything.
        ICombatLogX plugin = (ICombatLogX) Bukkit.getPluginManager().getPlugin("CombatLogX");
        ICombatManager combatManager = plugin.getCombatManager();
        return combatManager.isInCombat(player);
    }
}
