
package testmod.core.proxy;

import testmod.client.gui.GuiTest;
import testmod.client.render.item.ItemTileTestRenderer;
import testmod.client.render.tileentity.TileTestRenderer;
import testmod.lib.BlockIds;
import testmod.lib.GuiIds;
import testmod.lib.RenderIds;
import testmod.lib.Strings;
import testmod.tileentity.TileTest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void InitRendering()	{
		
		RenderIds.testRenderId = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileTest.class, new TileTestRenderer());
		
		MinecraftForgeClient.registerItemRenderer(BlockIds.BLOCK_TILETEST, new ItemTileTestRenderer());
		GameRegistry.registerTileEntity(TileTest.class, Strings.TE_TILETEST_NAME);
		
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null) {
			switch (ID) {
				case GuiIds.TEST:
					return new GuiTest(player, (TileTest) tileEntity);
			}
		}
		
		return null;
	}
}
