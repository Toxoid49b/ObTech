package me.whodoyoufear.obtech;

import net.minecraft.item.Item;

public class ObItems {

	public static Item simpleGateway;
	public static Item simpleGatewayActivated;
	public static Item obsidianCrystal;
	public static Item obsidianCrystalDust;
	public static Item quartzDust;
	
	public static void RegisterItems() {
		
		simpleGateway = new ItemSimpleGateway();
		simpleGatewayActivated = new ItemSimpleGatewayActivated();
		obsidianCrystal = new ItemObsidianCrystal();
		obsidianCrystalDust = new ItemObsidianCrystalDust();
		quartzDust = new ItemQuartzDust();
		
	}
	
}
