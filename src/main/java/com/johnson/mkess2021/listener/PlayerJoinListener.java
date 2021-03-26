package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PlayerJoinListener extends MyListener {
    //private int taskID = -1;

    public PlayerJoinListener(MkEss2021 instance) {
        super(instance);
    }
    private String format(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event){
        int count=0;
        Player player = event.getPlayer();
        BossBar bossBar = Bukkit.createBossBar(format("&6&l歡迎回來!! &f" + player.getName()), BarColor.PINK, BarStyle.SEGMENTED_6);

        bossBar.addPlayer(player);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            int count = -1;
            double progress = 1.0;
            double time = 1.0/30;

            @Override
            public void run() {
                bossBar.setProgress(progress);

                switch (count){
                    case -1:
                        break;
                    case 0:
                        bossBar.setColor(BarColor.BLUE);
                        bossBar.setTitle(format("&c&l請不要隨意說出自己的座標"));
                        break;
                    case 1:
                        bossBar.setColor(BarColor.PINK);
                        bossBar.setTitle(format("&c注意周遭可能藏有叛徒!"));
                        break;
                    case 2:
                        bossBar.removePlayer(player);
                        break;
                    default:
                        bossBar.setColor(BarColor.RED);
                        count = -1;
                        break;
                }
                progress = progress - time;
                if (progress <= 0){
                    count ++;
                    progress = 1.0;
                }
            }
        },0,20);

        /*new BukkitRunnable(){
            @Override
            public void run() {
                bossBar.removePlayer(player);
            }
        }.runTaskLater(plugin,20*4);*/


      }


}
