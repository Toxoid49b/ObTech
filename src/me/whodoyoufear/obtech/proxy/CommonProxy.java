package me.whodoyoufear.obtech.proxy;

import me.whodoyoufear.obtech.ModObTech;
import me.whodoyoufear.obtech.ObBlocks;
import me.whodoyoufear.obtech.ObItems;
import me.whodoyoufear.obtech.ObRecipies;
import me.whodoyoufear.obtech.ObUIHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


public class CommonProxy {
	
    public void PreInit(FMLPreInitializationEvent event) {
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(ModObTech.thisMod, new ObUIHandler());
    	
    }
    
    public void Init(FMLInitializationEvent event) {
		
    	ObBlocks.RegisterBlocks();
		ObItems.RegisterItems();
		ObRecipies.RegisterRecipies();
    	
    }
 
    public void PostInit(FMLPostInitializationEvent event) {
    	
    }
	
}
