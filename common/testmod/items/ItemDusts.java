
package testmod.items;

import testmod.TestMod;

public class ItemDusts extends ItemTM {
	public ItemDusts(int id) {

		super(id);
		this.setHasSubtypes(true);
		this.setCreativeTab(TestMod.tabsTM);
		maxStackSize = 64;
	}
}
