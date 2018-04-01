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
		types = new String[]{"str", "dex", "intel", "vit", "luc", "map", "mp", "rng"};
		player = p;
	}
	
	
	public void save() {
			PlayerStatConfig.set(player, statMap);
	}
	
	
	public void load() {
		statMap = PlayerStatConfig.get(player);
	}
}
