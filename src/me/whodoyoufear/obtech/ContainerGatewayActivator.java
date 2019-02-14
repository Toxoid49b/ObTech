package me.whodoyoufear.obtech;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerGatewayActivator extends Container {

	private TileEntityGatewayActivator baseEntity;
	
	public ContainerGatewayActivator(TileEntityGatewayActivator targetEntity, EntityPlayer player) {
		
		baseEntity = targetEntity;
 
        // Gateway item slot
		addSlotToContainer(new Slot(baseEntity, 0, 56, 17));
 
        // Player inventory
        for(int I = 0; I < 3; I++) {
            for(int J = 0; J < 9; J++) {
                addSlotToContainer(new Slot(player.inventory, J + I * 9 + 9, 8 + J * 18, 84 + I * 18));
            }
        }
        
        // Player hotbar
        for(int I = 0; I < 9; I++) {
            addSlotToContainer(new Slot(player.inventory, I, 8 + I * 18, 142));
        }
        
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotRaw) {
		
		ItemStack stack = null;
		Slot slot = (Slot)inventorySlots.get(slotRaw);
		
		if(slot != null && slot.getHasStack()) {
			
			ItemStack stackInSlot = slot.getStack();
			stack = stackInSlot.copy();
			
			if(slotRaw < 1) {
				if(!mergeItemStack(stackInSlot, 3, inventorySlots.size(), true)) {
					return null;
				}
			} else if(!mergeItemStack(stackInSlot, 0, 3, false)) {
                return null;
            }
			
			if(stackInSlot.stackSize == 0) {
				slot.putStack(null);
			} else {
				slot.onSlotChanged();
			}
			
		}
		
		return stack;
		
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return baseEntity.isUseableByPlayer(player);
	}
	
}
