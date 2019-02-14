package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemSimpleGateway extends Item {
	
	public static final String itemName = "simple_gateway";
	
	public ItemSimpleGateway() {		
		
		setUnlocalizedName(itemName);
		setTextureName(ModObTech.MOD_ID + ":" + itemName);
		GameRegistry.registerItem(this, getUnlocalizedName());
		setCreativeTab(ModObTech.modTab);
		
	}
	
}
