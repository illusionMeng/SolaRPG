package SolaRPG;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerStatConfig {
	
	public static void createConfig(Player player) throws IOException {
			File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
			FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
			stat.options().copyDefaults(true);
			stat.save(file);

	}
	
	
	public static HashMap<String, Integer> getStat(Player player) {	
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
		
		HashMap<String, Integer> pStat = new HashMap<String, Integer>();
		String type;
		int value;
		
		for(int i=0; i<PlayerStat.types.length; i++)
		{
			type = PlayerStat.types[i];
			value = stat.getInt("PlayerStat." + type);
			pStat.put(type, value);
		}
		
		return pStat;
	}
	
	
	public static void setStat(Player player, HashMap<String, Integer> pStat) throws IOException {
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
		String type;
		
		for(int i=0; i<PlayerStat.types.length; i++)
		{
			type = PlayerStat.types[i];
			stat.set("PlayerStat." + type, pStat.get(type));
		}
		stat.save(file);
	}
	
	
	public static void deleteConfig(Player player) {
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
		file.delete();
	}
}
