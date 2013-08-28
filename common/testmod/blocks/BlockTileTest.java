
package testmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import testmod.TestMod;
import testmod.lib.GuiIds;
import testmod.lib.Reference;
import testmod.lib.RenderIds;
import testmod.lib.Strings;
import testmod.tileentity.TileTest;

public class BlockTileTest extends BlockContainerTM {

	public BlockTileTest(int id) {

		super(id, Material.iron);
		this.setCreativeTab(TestMod.tabsTM);
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return RenderIds.testRenderId;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {

		return new TileTest();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, int id, int meta) {

		if (world.getBlockTileEntity(x, y, z) instanceof TileTest) {
			world.markBlockForUpdate(x, y, z);
			world.updateAllLightTypes(x, y, z);
		}

		super.breakBlock(world, x, y, z, id, meta);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float a, float b, float c) {
		player.openGui(Reference.MOD_ID, GuiIds.TEST, world, x, y, z);
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {}
}
