package SolaRPG;

import java.util.HashMap;

abstract class Stat {
	public static String[] types;
	public HashMap<String, String> statMap;
	

	public String getTypeValue(String type) {
		load();
		return statMap.get(type);
	}
	
	
	public void setTypeValue(String type, String value) {
		statMap.put(type, value);
		save();
	}
	
	
	public String[] getStats() {
		load();
		String[] typesArray = new String[types.length];
		
		for(int i=0; i<types.length; i++)
		{
			typesArray[i] = statMap.get(types[i]);
		}
		
		return typesArray;
	}
	
	
	public void setStats(String[] values) {
		for(int i=0; i<types.length; i++)
		{
			statMap.put(types[i], values[i]);
		}
		save();
	}
	
	
	abstract void save();
	
	abstract void load();
}

