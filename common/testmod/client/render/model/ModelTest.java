package testmod.client.render.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import testmod.lib.Models;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelTest {
	private IModelCustom modelTest;
	
	public ModelTest() {
		modelTest = AdvancedModelLoader.loadModel(Models.TEST);
		
	}
	
	public void render() {
		this.modelTest.renderAll();
	}
	
	public void renderPart(String partName) {
		this.modelTest.renderPart(partName);
	}
}
