
package testmod.blocks;

import net.minecraft.block.Block;
import testmod.client.render.tileentity.TileTestRenderer;
import testmod.lib.BlockIds;
import testmod.lib.Strings;
import testmod.tileentity.TileTest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block tileBlock;

	public static void init() {

		tileBlock = new BlockTileTest(BlockIds.BLOCK_TILETEST);

		GameRegistry.registerBlock(tileBlock, Strings.BLOCK_TE_TEST_NAME);
	}
}
