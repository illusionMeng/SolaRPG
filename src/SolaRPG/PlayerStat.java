package SolaRPG;

import org.bukkit.entity.Player;

public class PlayerStat extends Stat {
	
	
	private Player player;
	private String[] values;
	
	
	public PlayerStat(Player player) {
		this.player = player;
		
		types = new String[]{"name", "class", "str", "rng", "dex", "vit", "luc", "ap", "mp"};
		values = new String[]{player.getName(), "none", "10", "10", "10", "10", "10", "10", "10"};
		
		if(!StatConfig.exist("PlayerStat", player.getUniqueId().toString()))
		{
			create();
		}
		
		load();
	}
	
	
	private void create() {
		String[] defaultKey = new String[9];
		String[] defaultValue = new String[9];
		for(int i=0; i<9; i++)
		{
			defaultKey[i] = "PlayerStat." + types[i];
			defaultValue[i] = values[i];
		}
		
		StatConfig.createConfig("PlayerStat", player.getUniqueId().toString(), defaultKey, defaultValue);
	}
	
	
	public void save() {
		StatConfig.setStat("PlayerStat", player.getUniqueId().toString(), "PlayerStat", PlayerStat.types, statMap);
	}
	
	
	public void load() {
		statMap = StatConfig.getStat("PlayerStat", player.getUniqueId().toString(), "PlayerStat", PlayerStat.types);
	}
	
	public void delete() {
		StatConfig.deleteConfig("PlayerStat", player.getUniqueId().toString());
	}
}
