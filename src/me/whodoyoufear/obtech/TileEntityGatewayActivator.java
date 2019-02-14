package me.whodoyoufear.obtech;

import ic2.api.energy.prefab.BasicSink;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGatewayActivator extends TileEntity implements IInventory {
	
	public static final int MAX_BUFFER = 10000;
	
	 private BasicSink energySink = new BasicSink(this, MAX_BUFFER, 1);
	 private ItemStack gatewayItem;
	 public long entID;
	 
	 @Override
     public void invalidate() {
         energySink.invalidate();
         super.invalidate();
     }
	 
	 @Override
     public void onChunkUnload() {
         energySink.onChunkUnload();
     }
	 
	 @Override
     public void readFromNBT(NBTTagCompound tag) {
		 super.readFromNBT(tag);
         energySink.readFromNBT(tag);
     }
	 
	 @Override
     public void writeToNBT(NBTTagCompound tag) {
         super.writeToNBT(tag);
         energySink.writeToNBT(tag);
     }
	 
	 @Override
     public void updateEntity() {
         energySink.updateEntity();
         /*if(energySink.useEnergy(5)) { // use 5 eu from the sink's buffer this tick
         }*/
     }
	 
	 @Override
	 public int getSizeInventory() {		 
		 return 1;		 
	 }
	 
	 @Override
	 public ItemStack getStackInSlot(int slot) {
		 
		 return gatewayItem;
		 
	 }
	 
	 @Override
	 public ItemStack getStackInSlotOnClosing(int slot) {
		 
		 if(gatewayItem != null) {
			 ItemStack tmpItem = gatewayItem;
			 gatewayItem = null;
			 return tmpItem;
		 }
		 
		 return null;
		 
	 }
	 
	 public double GetEU() {
		 
		 return energySink.getEnergyStored();
		 
	 }
	 
	 @Override
	 public boolean isItemValidForSlot(int slot, ItemStack stack) {
		 
		 if(stack.getItem() instanceof ItemSimpleGateway) {
			 return true;
		 }
		 
		 return false;
		 
	 }
	 
	 @Override
	 public int getInventoryStackLimit() {
		 return 1;
	 }
	 
	 @Override
	 public void openInventory() {}
	 
	 @Override
	 public void closeInventory() {}
	 
	 @Override
	 public ItemStack decrStackSize(int slot, int ammount) {
		 
		 if(ammount == 1) {
			 ItemStack tmpStack = gatewayItem;
			 gatewayItem = null;
			 markDirty();
			 return tmpStack;
		 }
		 
		 return null;
		 
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemToSet) {
		gatewayItem = itemToSet;
		if(itemToSet != null && itemToSet.stackSize > 1) {
			itemToSet.stackSize = 1;
		}
		markDirty();		
	}

	@Override
	public String getInventoryName() {
		return "container.gatewayactivator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer targetPlayer) {		
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : targetPlayer.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}
	
	/*
	 * Gets the ammount of pixels to draw for the power storage indicator
	 */
	public int GetEnergyUIPercent() {
		double currentStored = energySink.getEnergyStored();
		double bufferSize = (double)MAX_BUFFER;
		double energyRatio = currentStored / bufferSize;
		double energyPercent = energyRatio / 14d;
		int pixelCount = (int)energyPercent;
		System.out.println(currentStored + " | " + bufferSize + " | " + energyRatio + " | " + energyPercent + " | " + pixelCount);
		return pixelCount;
	}
	
}
