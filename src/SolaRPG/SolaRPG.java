package SolaRPG;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class SolaRPG extends JavaPlugin {
	
	@Override
	public void onEnable() {
		defaultConfig();
		getServer().getPluginManager().registerEvents(new Event(this), this);
		getServer().getConsoleSender().sendMessage("[SolaRPG] SolaRPG Enabled!");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("[SolaRPG] SolaRPG Disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String args[]) {
		return false;
	}
	
	public void defaultConfig() {
		FileConfiguration config = this.getConfig();
		//config.addDefault("SolaRPGConfig.test", "test");
		config.options().copyDefaults(true);
		saveConfig();
	}
}
