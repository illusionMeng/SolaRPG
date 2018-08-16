package SolaRPG;

import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class SolaRPG extends JavaPlugin {
	
	@Override
	public void onEnable() {
		defaultConfig();
		getServer().getPluginManager().registerEvents(new Event(this), this);
		getServer().getConsoleSender().sendMessage("[SolaRPG] SolaRPG Enabled!");
		
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		NamespacedKey key;
	    ItemMeta test01 = items.get(0).getItemMeta();
	    test01.setDisplayName(ChatColor.GOLD + "破邪之劍");
	    test01.setLore(Arrays.asList(new String[] {
	       (ChatColor.WHITE + "擁有強大力量的劍") , 
	       (ChatColor.RED + "非常危險!")
	    }));
	    items.get(0).setItemMeta(test01);
		key = new NamespacedKey(this , "item01");
	    ShapedRecipe test1 = new ShapedRecipe(key, items.get(0)).shape("   ","!/!","   ")
	    .setIngredient('!',Material.BEDROCK)
	    .setIngredient('/',Material.GOLD_BLOCK);
	    getServer().addRecipe(test1);
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
