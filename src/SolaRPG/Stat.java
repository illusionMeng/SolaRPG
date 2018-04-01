package SolaRPG;

import java.util.HashMap;

abstract class Stat {
	public static String[] types;
	public HashMap<String, Integer> statMap;
	
	public Stat() {
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
	
	
	abstract void save();
	
	abstract void load();
}

