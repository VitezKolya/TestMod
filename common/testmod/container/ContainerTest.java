package testmod.container;

import testmod.tileentity.TileTest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;


public class ContainerTest extends Container {

	public ContainerTest(EntityPlayer player, TileTest tileEntity) {

		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCraftGuiClosed(EntityPlayer entityplayer) {
		super.onCraftGuiClosed(entityplayer);
		
	}
}
