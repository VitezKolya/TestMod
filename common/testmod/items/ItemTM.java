
package testmod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import testmod.TestMod;
import testmod.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ItemTM extends Item {

	public ItemTM(int id) {

		super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
		maxStackSize = 1;
		this.setCreativeTab(TestMod.tabsTM);
		setNoRepair();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {

		itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":"
				+ this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
}
