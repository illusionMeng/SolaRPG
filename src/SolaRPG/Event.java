package SolaRPG;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener {
	
	SolaRPG plugin;
	
	public Event(SolaRPG instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().sendMessage("gay");
		if(!event.getPlayer().hasPlayedBefore())
		{
			PlayerStatConfig.create(event.getPlayer());
		}

	}
}
