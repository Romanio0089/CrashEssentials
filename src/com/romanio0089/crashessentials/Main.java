package com.romanio0089.crashessentials;

import java.util.WeakHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	String color = "red";
	WeakHashMap<Location, String> selections = new WeakHashMap<Location, String>();

    @Override
    public void onEnable() {
    	
        getLogger().info("has been sucessfully enabled !");
        
        PluginManager pm = getServer().getPluginManager();
        PlayerJoinMessageListener listener = new PlayerJoinMessageListener(this);
        pm.registerEvents(listener, this);
        
        if ( getConfig().getString("color") == null ) {
        	getConfig().set("color", "red");
        	saveConfig();
        }
        
    }
	
    @Override
    public void onDisable() {
    	
        getLogger().info("has been sucessfully disabled !");
        
    }
    
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	Player player = (Player) sender;
    	
    	if (sender instanceof Player) {
    		
    		String lowerCmd = cmd.getName().toLowerCase();
    		
    		switch (lowerCmd) {
    		
    		case "realcrash":
                if (args.length == 0)
                    player.sendMessage(ChatColor.RED + "Not enough arguments!");
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Your target '" + args[0] + "' is not online!");
                } else {
                    String strtarget = args[0];
                    Location loc = target.getLocation();
                    player.sendMessage(ChatColor.GREEN + strtarget + " has been sucessfully crashed.");
                    target.spawnParticle(Particle.MOB_APPEARANCE, loc, 100000000, 0, 0, 0);
                    target.kickPlayer("Their game crashed!");
                return true;
    	}
    	
	}
		return false;
    	
	}
}
		return false;

	}
	
}