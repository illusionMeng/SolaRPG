package SolaRPG;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerStatConfig {
	
	public static void create(Player player) {
		StatConfig.createConfig("PlayerStat", player.getUniqueId().toString());
	}
	
	public static HashMap<String, Integer> get(Player player) {
		return StatConfig.getStat("PlayerStat", player.getUniqueId().toString(), "PlayerStat", PlayerStat.types);
	}
	
	public static void set(Player player, HashMap<String, Integer> statMap) {
		StatConfig.setStat("PlayerStat", player.getUniqueId().toString(), "PlayerStat", PlayerStat.types, statMap);
	}
	
	public static void delete(Player player) {
		StatConfig.deleteConfig("PlayerStat", player.getUniqueId().toString());
	}
	
}
