package SolaRPG;

import java.io.File;
import java.io.IOException;

import org.bukkit.Statistic;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class PlayerStatConfig {
	
	public static void createConfig(Player player) {
		try
		{
			File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
			FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
			stat.options().copyDefaults(true);
			stat.save(file);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static PlayerStat getStat(Player player) {
		PlayerStat pStat = new PlayerStat();
		
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
		FileConfiguration stat = YamlConfiguration.loadConfiguration(file);
		return null;
		
	}
	
	public static void setStat(Player player, PlayerStat pStat) {
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
	}
	
	public static void deleteConfig(Player player) {
		File file = new File("plugins/SolaRPG/PlayerStat", player.getUniqueId().toString());
		file.delete();
	}
}
