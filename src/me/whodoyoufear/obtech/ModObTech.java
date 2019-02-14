package me.whodoyoufear.obtech;

import me.whodoyoufear.obtech.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModObTech.MOD_ID, version = "0.0.1")
public class ModObTech {
	
	public static final String MOD_ID = "obtech";
	public static final String CLIENT_PROXY = "me.whodoyoufear.obtech.proxy.ClientProxy";
	public static final String SERVER_PROXY = "me.whodoyoufear.obtech.proxy.ServerProxy";
	
	@Mod.Instance(MOD_ID)
	public static ModObTech thisMod = new ModObTech();
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
    public static CommonProxy proxy;
	
	public static final CreativeTabs modTab = (new CreativeTabs("tab_obtech") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(ObBlocks.denseObsidian).getItem();
		}
	});
	
	@Mod.EventHandler
    public void ModPreInit(FMLPreInitializationEvent event) {
		
		System.out.println("[| [ ObTech for Minecraft 1.7.10 ] |]");
		proxy.PreInit(event);
		
	}
	
	@Mod.EventHandler
    public void ModInit(FMLInitializationEvent event) {
		
		proxy.Init(event);
		
    }
 
    @Mod.EventHandler
    public void ModPostInit(FMLPostInitializationEvent event) {
    	
    	proxy.PostInit(event);
    	
    }    
	
}
