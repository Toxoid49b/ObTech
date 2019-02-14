package me.whodoyoufear.obtech.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
	
    public void PreInit(FMLPreInitializationEvent event) {
    	super.PreInit(event);
    }
    
    public void Init(FMLInitializationEvent event) {
		super.Init(event);
    }
 
    public void PostInit(FMLPostInitializationEvent event) {
    	super.PostInit(event);
    }
	
}
