package me.whodoyoufear.obtech;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ObUIHandler implements IGuiHandler {

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity targetEnt = world.getTileEntity(x, y, z);
		if(targetEnt != null) {
			
			switch(ID) {
			
			case 0:
				return new ContainerGatewayActivator((TileEntityGatewayActivator) targetEnt, player);
			
			}
			
		}
		
		return null;
		
	}
	
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity targetEnt = world.getTileEntity(x, y, z);
		if(targetEnt != null) {
		
			switch(ID) {
			
			case 0:
				if(targetEnt instanceof TileEntityGatewayActivator) {
					return new UIGatewayActivator((TileEntityGatewayActivator)targetEnt, player);
				}
				break;
			
			}
		
		}
		
		return null;
		
	}
	
}
