package testmod.client.gui;

import org.lwjgl.opengl.GL11;

import testmod.container.ContainerTest;
import testmod.lib.Textures;
import testmod.tileentity.TileTest;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;


public class GuiTest extends GuiContainer {
	
	private GuiButton testButton;
	private TileTest tileEntity;
	
	public GuiTest(EntityPlayer player, TileTest tileEntity) {
		
		super(null);
		
		this.tileEntity = tileEntity;
	}
	
	@Override
	public void initGui() {
		super.initGui();
		
		int guiWidth = (this.width - xSize) / 2;
		int guiHeight = (this.height - ySize) / 2;
		
		buttonList.clear();
		buttonList.add(this.testButton = new GuiButton(0, guiWidth + 58, guiHeight + 47, 60,20,"Press Me"));
	}
	
	@Override
	protected void actionPerformed(GuiButton guibutton) {
		if(guibutton.id == 0) {
			
		}
	}
	
	
	
	@Override
    protected void drawGuiContainerForegroundLayer(int param1, int param2) {
		//draw text and stuff here
		//The parameters for drawString are: string, x,y,color
		fontRenderer.drawString("", 8, 6, 4210752);
		
		// draws "Inventory" or your regional equivalent
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {

		this.mc.renderEngine.bindTexture(Textures.GUI_TEST);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
	}

}
