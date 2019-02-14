package me.whodoyoufear.obtech;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemQuartzDust extends Item {

	public static final String itemName = "quartz_dust";
	
	public ItemQuartzDust() {
		
		setUnlocalizedName(itemName);
		setTextureName(ModObTech.MOD_ID + ":" + itemName);
		GameRegistry.registerItem(this, getUnlocalizedName());
		setCreativeTab(ModObTech.modTab);
		OreDictionary.registerOre("dustNetherQuartz", this);
		
	}
	
}
