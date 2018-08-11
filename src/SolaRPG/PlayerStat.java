package SolaRPG;

import org.bukkit.entity.Player;

public class PlayerStat extends Stat {
//	private FileConfiguration config;
//	
//	public PlayerStat(SolaRPG solaRPG) {
//		config = solaRPG.getConfig();
//
//	}
	
	private Player player;
	
	public PlayerStat(Player p) {
		super();
		types = new String[]{"class", "str", "rng", "dex", "vit", "luc", "ap", "mp"};
		player = p;
	}
	
	
	public void save() {
		PlayerStatConfig.set(player, statMap);
	}
	
	
	public void load() {
		statMap = PlayerStatConfig.get(player);
	}
}
