package helloworld;

import org.bukkit.event.*;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class Item extends JavaPlugin implements Listener{
	protected static ItemStack item01, item02;
	static {
		item01 = new ItemStack(Material.DIAMOND_SWORD, (short) 1);
		item02 = new ItemStack(Material.PAPER, (short) 1);
	}
	@Override
	public void onEnable(){
		this.getConfig().options().copyDefaults(true);
	    saveConfig();
	    reloadConfig();
		NamespacedKey key;
		getServer().getPluginManager().registerEvents(this,this);
	    ItemMeta test01 = item01.getItemMeta();
	    test01.setDisplayName(ChatColor.GOLD + "破邪之劍");
	    test01.setLore(Arrays.asList(new String[] {
	       (ChatColor.WHITE + "擁有強大力量的劍") , 
	       (ChatColor.RED + "非常危險!")
	    }));
	    item01.setItemMeta(test01);
		key = new NamespacedKey(this , "item01");
	    ShapedRecipe test1 = new ShapedRecipe(key, item01).shape("   ","!/!","   ")
	    .setIngredient('!',Material.BEDROCK)
	    .setIngredient('/',Material.GOLD_BLOCK);
	    getServer().addRecipe(test1);
	    
	    ItemMeta test2 = item02.getItemMeta();
	    test2.setDisplayName(ChatColor.RED + "teleport");
	    test2.setLore(Arrays.asList(new String[] {
	       (ChatColor.WHITE + "tp")
	    }));
	    item02.setItemMeta(test2);
	    key = new NamespacedKey(this , "item02");
	    ShapedRecipe test3 = new ShapedRecipe(key, item02).shape("   "," / ","   ")
	    .setIngredient('/',Material.GOLD_BLOCK);
	    getServer().addRecipe(test3);
	}
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdlable, String[] args) {
    	Player player = (Player) sender;
    	if(cmdlable.equals("gay")) {
    		if(args.length != 0) {
    			switch(args[0]) {
        		case "give": if(args.length == 2) {
        							giveitem(player, args);
        					} else { player.sendMessage("gay u"); }
        				     break;
        				    
    		    
        		case "reload": reloadConfig();
        					   player.sendMessage(ChatColor.GREEN + "reload complete!");
        					   break;
        					   
        		case "setmotd": if(args.length == 1) {
								player.sendMessage("gay u"); 
								} else {
									 String a = "";
								        for(int i=0;i<args.length;i++) {
								            a += args[i] + " ";
								        }
								        getConfig().set("Motd" , a);
								        saveConfig();
								        player.sendMessage(ChatColor.GREEN + "成功設置MOTD!");
								}
        						break;
    		    				
    		    default: player.sendMessage("u up wt7");
    		    		 break;
        			}
    	  		
        		return true;
        		
    		} else {
    			player.sendMessage("help");
    			return true;
    		}
    	}
    	return false;
    }
    public void giveitem(Player player, String[] args) {
            switch(args[1]) {
            case "001":
                player.getInventory().addItem(item01);
                player.updateInventory();
                break;
            case "002":
                player.getInventory().addItem(item02);
                player.updateInventory();
                break;
            default:
            	player.sendMessage(ChatColor.RED + "無此物品編號!");
            }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInMainHand().equals(item02)) {
        	p.sendMessage(ChatColor.GREEN + "tp in 3 second");
        	getServer().getScheduler().runTaskLater(this, new Runnable() {
        	    public void run() {
        	    	p.teleport(new Location(p.getWorld() , 27,65,-679));
                    p.sendMessage(ChatColor.GREEN + "傳送成功!");
        	    }
        	}, 20*3);
        }
        if((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getInventory().getItemInMainHand().equals(item01)) {
        	p.sendMessage(ChatColor.GREEN + "gayd");
        	

        }
    }
    @EventHandler
    public void onPlay(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GREEN +  "*******************");
        p.sendMessage(ChatColor.YELLOW + "******welcome******");
        p.sendMessage(ChatColor.GREEN +  "*******************");
    }
    public void onDisable(){
        getServer().clearRecipes();
    }
}
