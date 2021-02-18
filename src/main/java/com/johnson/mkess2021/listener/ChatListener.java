package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener extends MyListener {
    public ChatListener(MkEss2021 instance) {
        super(instance);
    }
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        String Msg = event.getMessage();
        String world = p.getWorld().getName();

        Location location = p.getLocation();

        Msg = Msg.replace("%", "%%");

        if (Msg.substring(0,1).equals("#")){
            if ( Msg.substring(1).length() == 0 ){
                p.sendMessage( ChatColor.RED +  "訊息不能為空");
                event.setCancelled(true);
            }
            else if ( Msg.getBytes().length > 100 ) {
                p.sendMessage( ChatColor.RED+ "請勿發送過長訊息 (限制 100 字元內)");
            }
            else {
                Msg = Msg.substring(1);
                String Global = " [世界] ";
                event.setFormat(ChatColor.RED + Global + p.getName() + ": " + ChatColor.WHITE + Msg );
            }
        }
        else if ( Msg.substring(0,1).equals("$")){
            if ( Msg.substring(1).length() == 0 ){
                p.sendMessage( ChatColor.RED +  "訊息不能為空");
                event.setCancelled(true);
            }
            else if ( Msg.getBytes().length > 100 ) {
                p.sendMessage( ChatColor.RED+ "請勿發送過長訊息 (限制 100 字元內)");
            }
            else {
                Msg = Msg.substring(1);
                String Trade = " [交易] ";
                event.setFormat(ChatColor.GOLD + Trade + p.getName() + ": " + ChatColor.WHITE + Msg );
            }
        }
        else {
            int count = 0;
            String Area = " [區域] ";

            for(Player pl: event.getRecipients()){
                String wd = pl.getWorld().getName();

                if ( wd.equals(world) && pl.getLocation().distance(location) <= 32 ){
                    pl.sendMessage( ChatColor.GRAY + Area +  p.getName() + ": " + ChatColor.WHITE + Msg);
                    count ++;
                }
            }
            if ( count == 1 ){
                p.sendMessage("§7<§f系統§7> " + "§c偵測到附近沒有玩家! 請使用其他頻道.");
            }
            else {
                count = 1;
            }
            event.getRecipients().clear();
        }
    }

}
