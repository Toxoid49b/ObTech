package me.whodoyoufear.obtech;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class UIGatewayActivator extends GuiContainer {
	
	public static final int UI_ID = 0;
	
	private ResourceLocation uiBackground = new ResourceLocation(ModObTech.MOD_ID, "textures/ui/gateway_activator_ui.png");
	private TileEntityGatewayActivator baseEntity;
	private InventoryPlayer playerInventory;
	
	public UIGatewayActivator(TileEntityGatewayActivator targetEntity, EntityPlayer player) {
        super(new ContainerGatewayActivator(targetEntity, player));
        playerInventory = player.inventory;
        baseEntity = targetEntity;
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		
		mc.renderEngine.bindTexture(uiBackground);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
		System.out.println(baseEntity.entID);
		drawTexturedModalRect(x + 57, y + 37, 176, 0, 14, baseEntity.GetEnergyUIPercent());
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		fontRendererObj.drawString(I18n.format(baseEntity.getInventoryName()), (xSize / 2) - (fontRendererObj.getStringWidth(I18n.format(baseEntity.getInventoryName())) / 2), 6, 4210752, false);
		fontRendererObj.drawString(I18n.format(playerInventory.getInventoryName()), 8, ySize - 96 + 2, 4210752);
		
	}
	
}
