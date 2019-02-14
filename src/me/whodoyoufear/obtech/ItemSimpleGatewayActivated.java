package me.whodoyoufear.obtech;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemSimpleGatewayActivated  extends Item {
	
	public static final String itemName = "simple_gateway_activated";
	
	public ItemSimpleGatewayActivated() {		
		
		setUnlocalizedName(itemName);
		setTextureName(ModObTech.MOD_ID + ":" + itemName);
		GameRegistry.registerItem(this, getUnlocalizedName());
		setCreativeTab(ModObTech.modTab);
		
	}
	
}