package me.whodoyoufear.obtech;

import ic2.api.item.IC2Items;
import ic2.api.recipe.RecipeInputItemStack;
import ic2.api.recipe.Recipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ObRecipies {

	@SuppressWarnings("unchecked")
	public static void RegisterRecipies() {
		
		GameRegistry.addRecipe(new ItemStack(ObBlocks.denseObsidian), "XXX", "XXX", "XXX", 'X', Blocks.obsidian);
		GameRegistry.addRecipe(new ItemStack(ObItems.simpleGateway), "XXX", "X@X", "XXX", 'X', ObBlocks.denseObsidian, '@', Items.ender_pearl);
		GameRegistry.addRecipe(new ItemStack(ObBlocks.gateActivator), "DCD", "@M@", "D#D", 'D', ObBlocks.denseObsidian, '#', IC2Items.getItem("electronicCircuit"), '@', IC2Items.getItem("coil"), 'M', IC2Items.getItem("machine"), 'C', ObItems.obsidianCrystal);
		
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(ObItems.obsidianCrystalDust, 2), "dustObsidian", "dustNetherQuartz"));
		
		Recipes.compressor.addRecipe(new RecipeInputItemStack(new ItemStack(ObItems.obsidianCrystalDust)), null, new ItemStack(ObItems.obsidianCrystal));
		Recipes.macerator.addRecipe(new RecipeInputItemStack(new ItemStack(Items.quartz)), null, new ItemStack(ObItems.quartzDust));
		
	}
	
}
