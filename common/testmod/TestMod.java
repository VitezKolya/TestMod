
package testmod;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import testmod.blocks.ModBlocks;
import testmod.configuration.ConfigurationHandler;
import testmod.core.handlers.LocalizationHandler;
import testmod.core.proxy.CommonProxy;
import testmod.creativetab.CreativeTabAE;
import testmod.lib.Reference;
import universalelectricity.prefab.network.PacketManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

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
@NetworkMod(channels={Reference.CHANNEL_NAME}, clientSideRequired=true, serverSideRequired=false, packetHandler = PacketManager.class)
public class TestMod {

	@Instance(Reference.MOD_ID)
	public static TestMod instance;
	
	@Metadata(Reference.MOD_ID)
    public static ModMetadata meta;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tabsTM = new CreativeTabAE(CreativeTabs.getNextID(), Reference.MOD_ID);

	public static Logger AELogger = Logger.getLogger(Reference.MOD_ID);
	
	public static void log(Level level, String msg, String... replacements) {
		for(String replace: replacements) {
			msg = msg.replace("%s", replace);
		}
		
		AELogger.log(level, msg);
	}
	
	/**
	 * This is were you load up blocks/items
	 * 
	 * @param event
	 */
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
		log(Level.INFO, "PreInitializing " + Reference.MOD_ID + " version: " + meta.version);
		
		LocalizationHandler.loadLanguages();

		// Initialize the configuration
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator
				+ Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));

		ModBlocks.init();
		//ModItems.init();
		
		NetworkRegistry.instance().registerGuiHandler(this, TestMod.proxy);
	}

	@Init
	public void init(FMLInitializationEvent event) {

		log(Level.INFO, "Initializing " + Reference.MOD_ID + " version: " + meta.version);
		
		proxy.InitRendering();
	

	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		log(Level.INFO, "PostInitializing " + Reference.MOD_ID + " version: " + meta.version);
	}
}

