package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemObsidianCrystal extends Item {

	public static final String itemName = "obsidian_crystal";
	
	public ItemObsidianCrystal() {
		
		setUnlocalizedName(itemName);
		setTextureName(ModObTech.MOD_ID + ":" + itemName);
		GameRegistry.registerItem(this, getUnlocalizedName());
		setCreativeTab(ModObTech.modTab);
		OreDictionary.registerOre("crystalObsidian", this);
		
	}
	
}
