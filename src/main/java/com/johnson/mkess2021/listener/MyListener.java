package com.johnson.mkess2021.listener;

import com.johnson.mkess2021.MkEss2021;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class MyListener implements Listener {
    protected MkEss2021 plugin;
    public MyListener(MkEss2021 instance){
        this.plugin = instance;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    public void unregisterListener(){
        HandlerList.unregisterAll(this);
    }
}
