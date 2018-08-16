package SolaRPG;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler extends JavaPlugin implements Listener{
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
    	Player player = (Player) sender;
    	if(cmdlable.equalsIgnoreCase("solarpg")) {
    		if(args.length != 0) {
    			switch(args[0].toLowerCase()) {
    			
        		case "help": help(player);
        				    break;
        				    
        		case "item": item(player, args);   
    		    			 break; 
        			
        		case "setstat": setstat(player, args);
        						break;
        			
        		case "setclass": setclass(player, args);
        						 break;
    		    
        		case "reload": reloadConfig();
        					   player.sendMessage(ChatColor.GREEN + "reload complete!");
        					   break;
    		    				
    		    default: help(player);
    		    		 break;
        			}
    	  		
        		return true;
        		
    		} else {
    			help(player);
    			return true;
    		}
    	}
    	return false;
    }
	
	private void help(Player player) {
		player.sendMessage(ChatColor.GREEN + "***SolaRPG help***");
		player.sendMessage(ChatColor.GREEN + "/solarpg help - help for solarpg");
		player.sendMessage(ChatColor.GREEN + "/solarpg item give <player name> <item id>- give item to certain player");
		player.sendMessage(ChatColor.GREEN + "/solarpg item create <item id> <item material>");
		player.sendMessage(ChatColor.GREEN + "/solarpg item set <name/lore/stat> <para> - set item name/lore/stat");
		player.sendMessage(ChatColor.GREEN + "/solarpg setclass <player> <class> - set a player class");
		player.sendMessage(ChatColor.GREEN + "/solarpg reload - reload config");
		
	}
	
	public void item(Player player, String[] args) {
		if(args.length != 1) {
			switch(args[0].toLowerCase()) {
			
    		case "give": giveItem(player, args);
    				    break;
    				    
    		case "create": createItem(args);   
		    			 break; 
    			
    		case "set": setItem(args);
    						break;
    						
		    default: player.sendMessage(ChatColor.RED + "/solarpg item <give/create/set> <para1> <para2>");
		    		 break;
    			}	  		    		
		} else {
			player.sendMessage(ChatColor.RED + "/solarpg item <give/create/set> <para1> <para2>");
		}
	}
	
	public void giveItem(Player player, String[] args) {
		if(args.length == 4) {
			for(Player p:this.getServer().getOnlinePlayers()){
				if (args[3] == p.getName()) {
			//		p.getInventory().addItem(null);
				}
			}
		}
	}
	
	public void createItem(String[] args) {
	//config
	}

	public void setItem(String[] args) {
	//config
	}
	
	public void setstat(Player player, String[] args) {
	//config
	}
	
	public void setclass(Player player, String[] args) {
	//config	
	}
	
}

