package SolaRPG;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class PlayerStat {
//	private FileConfiguration config;
//	
//	public PlayerStat(SolaRPG solaRPG) {
//		config = solaRPG.getConfig();
//
//	}
	
	private String[] types = {"str", "dex", "intel", "vit", "luc", "map", "mp", "rng"};
	private HashMap<String, Integer> statMap;
	
	public PlayerStat() {
		for(String s : types)
		{
			statMap.put(s, 0);
		}
	}
	
	
	public PlayerStat(Player p) {
		
	}
	
	
	public int getTypeValue(String type) {
		return statMap.get(type);
	}
	
	
	public void setTypeValue(String type, int value) {
		statMap.put(type, value);
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
	}
	
}
