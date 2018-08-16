package SolaRPG;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {
	
	SolaRPG plugin;
	
	public Event(SolaRPG instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		PlayerStat playerStat = new PlayerStat(event.getPlayer()); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("name")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("class")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("str")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("rng")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("dex")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("vit")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("luc")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("ap")); //test
		event.getPlayer().sendMessage(playerStat.getTypeValue("mp")); //test
		
	}
	
    @EventHandler
    public void onEntitySpawn(ItemSpawnEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof ExperienceOrb){
            event.setCancelled(true);
        }
    }
    
	@EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
     //   UUID uuid = player.getUniqueId();
        String name = player.getName();
        String msg = event.getMessage();
        if(player.isOp() == true)
        {
        	name = ChatColor.RED + name;
        	msg = ChatColor.WHITE + msg;
        }
        String className = ChatColor.WHITE + "¹C«È";

        event.setFormat(ChatColor.WHITE + "[µ¥¯Å" + ChatColor.GREEN + player.getLevel() + ChatColor.LIGHT_PURPLE + " " + className + ChatColor.WHITE + "] " + ChatColor.GRAY + name + ChatColor.GRAY + ": " + msg);
    }
	
	@EventHandler
    public void onPlayerFall(EntityDamageEvent event) {
    	if(event.getCause() == DamageCause.FALL)
    	{
    		event.setDamage(0);
    	}
    }
}
