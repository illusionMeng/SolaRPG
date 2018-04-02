package SolaRPG;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class StatConfig {
	public static void createConfig(String path, String fileName, String[] defaultKey, String[] defaultValue) {
		File file = new File("plugins/SolaRPG/" + path, fileName);
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
		
		for(int i=0; i<defaultKey.length; i++)
		{
			stat.addDefault(defaultKey[i], defaultValue[i]);
		}
		
		stat.options().copyDefaults(true);
		try 
		{
			stat.save(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}


	public static HashMap<String, Integer> getStat(String path, String fileName, String key, String[] types) {	
		File file = new File("plugins/SolaRPG/" + path, fileName);
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
	
		HashMap<String, Integer> statMap = new HashMap<String, Integer>();
		String type;
		int value;
	
		for(int i=0; i<types.length; i++)
		{
			type = types[i];
			value = stat.getInt(key + "." + type);
			statMap.put(type, value);
		}
	
		return statMap;
	}


	public static void setStat(String path, String fileName, String key, String[] types, HashMap<String, Integer> statMap) {
		File file = new File("plugins/SolaRPG/" + path, fileName);
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
		String type;
	
		for(int i=0; i<types.length; i++)
		{
			type = types[i];
			stat.set(key + "." + type, statMap.get(type));
		}
		
		try 
		{
			stat.save(file);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


	public static void deleteConfig(String path, String fileName) {
		File file = new File("plugins/SolaRPG/" + path, fileName);
		file.delete();
	}
}
