package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockDenseObsidian extends Block {
	
	private static final String blockName = "dense_obsidian";
	
	public BlockDenseObsidian() {
		
        super(Material.rock);
        GameRegistry.registerBlock(this, blockName);
        setBlockName(blockName);
        setBlockTextureName(ModObTech.MOD_ID + ":" + blockName);
        setCreativeTab(ModObTech.modTab);
        setHardness(55.0f);
        
    }
	
}
