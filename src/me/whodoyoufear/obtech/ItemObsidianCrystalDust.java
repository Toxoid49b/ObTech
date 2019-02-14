package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class ItemObsidianCrystalDust extends Item {

	public static final String itemName = "obsidian_crystal_dust";
	
	public ItemObsidianCrystalDust() {
		
		setUnlocalizedName(itemName);
		setTextureName(ModObTech.MOD_ID + ":" + itemName);
		GameRegistry.registerItem(this, getUnlocalizedName());
		setCreativeTab(ModObTech.modTab);
		OreDictionary.registerOre("dustObsidianCrystal", this);
		
	}
	
}
