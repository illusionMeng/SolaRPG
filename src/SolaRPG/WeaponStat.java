package SolaRPG;

import java.util.HashMap;


public class WeaponStat {
	public HashMap<String, String> weaponStatMap;
	
	private static String[] weaponTypes;
	public void getWeapon() {
		weaponTypes = new String[] {"name", "material", "minAtk", "maxAtk", "atkspd", "def", "critChance"};
		weaponStatMap = StatConfig.getStat("weapon", "weapon", "weaponStat", weaponTypes);
	}		

}