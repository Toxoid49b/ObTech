package me.whodoyoufear.obtech;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockGatewayActivator extends BlockContainer {

	private static final String blockName = "gateway_activator";
	private IIcon blockFront;
	private IIcon blockSides;
	
	public BlockGatewayActivator() {
		
        super(Material.iron);
        GameRegistry.registerBlock(this, blockName);
        setBlockName(blockName);
        setBlockTextureName(ModObTech.MOD_ID + ":" + blockName);
        setCreativeTab(ModObTech.modTab);
        setHardness(10.0f);
        
    }
	
	@Override
    public void registerBlockIcons(IIconRegister iconRegister) {
		blockSides = iconRegister.registerIcon(ModObTech.MOD_ID + ":machine_side");
        blockFront = iconRegister.registerIcon(ModObTech.MOD_ID + ":" + blockName + "_front");
    }
 
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == meta) ? blockFront : blockSides; 
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float lx, float ly, float lz) {
        if(world.isRemote) return true;        
        TileEntity te = world.getTileEntity(x, y, z);
        if (te != null && te instanceof TileEntityGatewayActivator) {
        	player.openGui(ModObTech.thisMod, UIGatewayActivator.UI_ID, world, x, y, z);
            return true;
        }
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityGatewayActivator();
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase targetEntity, ItemStack srcItem) {
    	
    	int entDirection = MathHelper.floor_double((targetEntity.rotationYaw * 4.0f / 360.0f) + 0.5f) & 3;
    	
    	switch(entDirection) {
    	
    	case 0:
    		world.setBlockMetadataWithNotify(x, y, z, 2, 2);
    		break;
    		
    	case 1:
    		world.setBlockMetadataWithNotify(x, y, z, 5, 2);
    		break;
    		
    	case 2:
    		world.setBlockMetadataWithNotify(x, y, z, 3, 2);
    		break;
    		
    	case 3:
    		world.setBlockMetadataWithNotify(x, y, z, 4, 2);
    		break;
    	
    	}
    	
    }
	
}
