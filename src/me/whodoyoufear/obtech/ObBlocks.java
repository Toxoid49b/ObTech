package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ObBlocks {

	public static Block denseObsidian;
	public static Block gateActivator;
	
	public static void RegisterBlocks() {
	
		denseObsidian = new BlockDenseObsidian();
		gateActivator = new BlockGatewayActivator();
		
		GameRegistry.registerTileEntity(TileEntityGatewayActivator.class, ModObTech.MOD_ID + ":ent_gate_activator");
	
	}
	
}
