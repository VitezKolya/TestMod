
package testmod.core.proxy;

import testmod.client.render.item.ItemTileTestRenderer;
import testmod.client.render.tileentity.TileTestRenderer;
import testmod.lib.BlockIds;
import testmod.lib.RenderIds;
import testmod.tileentity.TileTest;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void InitRendering()	{
		
		RenderIds.testRenderId = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileTest.class, new TileTestRenderer());
		
		MinecraftForgeClient.registerItemRenderer(BlockIds.BLOCK_TILETEST, new ItemTileTestRenderer());
	}
}
