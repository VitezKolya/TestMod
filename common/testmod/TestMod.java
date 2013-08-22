
package testmod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import testmod.blocks.ModBlocks;
import testmod.configuration.ConfigurationHandler;
import testmod.core.handlers.LocalizationHandler;
import testmod.core.proxy.CommonProxy;
import testmod.creativetab.CreativeTabAE;
import testmod.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Test Mod
 * 
 * TestMod
 * 
 * @author VitezKolya
 * @license GNU Public License v3 (http://www.gnu.org/licenses/gpl.html)
 * 
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TestMod {

	@Instance(Reference.MOD_ID)
	public static TestMod instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tabsTM = new CreativeTabAE(CreativeTabs.getNextID(), Reference.MOD_ID);

	
	
	/**
	 * This is were you load up blocks/items
	 * 
	 * @param event
	 */
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {

		LocalizationHandler.loadLanguages();

		// Initialize the configuration
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator
				+ Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));

		ModBlocks.init();
		//ModItems.init();
		
		
	}

	@Init
	public void init(FMLInitializationEvent event) {

		proxy.InitRendering();
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {

	}
}

