
package testmod.core.proxy;

import testmod.client.gui.GuiTest;
import testmod.container.ContainerTest;
import testmod.lib.GuiIds;
import testmod.tileentity.TileTest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	public void InitRendering() {

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

		if (tileEntity != null) {
			switch (ID) {
				case GuiIds.TEST:
					//return new ContainerTest(player, (TileTest) tileEntity);
					break;
			}
		}

		return null;
	}
}
