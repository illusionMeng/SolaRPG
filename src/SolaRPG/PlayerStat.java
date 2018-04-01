package SolaRPG;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerStat {
//	private FileConfiguration config;
//	
//	public PlayerStat(SolaRPG solaRPG) {
//		config = solaRPG.getConfig();
//
//	}
	
	public static String[] types = {"str", "dex", "intel", "vit", "luc", "map", "mp", "rng"};
	private HashMap<String, Integer> statMap;
	private Player player;
	
	public PlayerStat(Player p) {
		player = p;
		load();
	}
	
	
	public int getTypeValue(String type) {
		return statMap.get(type);
	}
	
	
	public void setTypeValue(String type, int value) {
		statMap.put(type, value);
		save();
	}
	
	
	public int[] getStats() {
		int[] typesArray = new int[types.length];
		
		for(int i=0; i<types.length; i++)
		{
			typesArray[i] = statMap.get(types[i]);
		}
		
		return typesArray;
	}
	
	
	public void setStats(int[] values) {
		for(int i=0; i<types.length; i++)
		{
			statMap.put(types[i], values[i]);
		}
		save();
	}
	
	
	public void save() {
		try
		{
			PlayerStatConfig.setStat(player, statMap);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void load() {
		statMap = PlayerStatConfig.getStat(player);
	}
}
