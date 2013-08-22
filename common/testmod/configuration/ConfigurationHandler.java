
package testmod.configuration;

import java.io.File;
import java.util.logging.Level;

import testmod.lib.ItemIds;
import net.minecraftforge.common.Configuration;
import testmod.lib.BlockIds;
import testmod.lib.Reference;
import testmod.lib.Strings;
import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler {
	public static Configuration configuration;

	public static final String CATEGORY_GRAPHICS = "graphics";
	public static final String CATEGORY_GENERATION = "gerneration";
	public static final String CATEGORY_AUDIO = "audio";
	public static final String CATEGORY_BLOCK = "block";
	public static final String CATEGORY_ITEM = "item";

	public static void init(File configFile) {

		configuration = new Configuration(configFile);

		try {

			configuration.load();
			
			/* Item configs */
			ItemIds.STRANGE_CRYSTAL = configuration.getItem(Strings.GEM_STRANGE_CRYSTAL_NAME,
					ItemIds.STRANGE_CRYSTAL_DEFAULT).getInt(ItemIds.STRANGE_CRYSTAL_DEFAULT);
			ItemIds.STRANGE_CRYSTAL_DUST = configuration.getItem(Strings.ITEM_STRANGE_CRYSTAL_DUST_NAME,
					ItemIds.STRANGE_CRYSTAL_DUST_DEFAULT).getInt(ItemIds.STRANGE_CRYSTAL_DUST_DEFAULT);
			ItemIds.QUARTZ_DUST = configuration.getItem(Strings.ITEM_QUARTZ_DUST_NAME, ItemIds.QUARTZ_DUST_DEFAULT)
					.getInt(ItemIds.QUARTZ_DUST_DEFAULT);
			ItemIds.TINY_QUARTZ_DUST = configuration.getItem(Strings.ITEM_TINY_QUARTZ_DUST_NAME,
					ItemIds.TINY_QUARTZ_DUST_DEFAULT).getInt(ItemIds.TINY_QUARTZ_DUST_DEFAULT);
			ItemIds.DIAMOND_DUST = configuration.getItem(Strings.ITEM_DIAMOND_DUST_NAME, ItemIds.DIAMOND_DUST_DEFAULT)
					.getInt(ItemIds.DIAMOND_DUST_DEFAULT);
			ItemIds.TINY_DIAMOND_DUST = configuration.getItem(Strings.ITEM_TINY_DIAMOND_DUST_NAME,
					ItemIds.TINY_DIAMOND_DUST_DEFAULT).getInt(ItemIds.TINY_DIAMOND_DUST_DEFAULT);

			/* Block configs */
			BlockIds.BLOCK_TILETEST = configuration.getBlock(Strings.BLOCK_TE_TEST_NAME,
					BlockIds.BLOCK_TILETEST_DEFAULT).getInt(BlockIds.BLOCK_TILETEST_DEFAULT);

		} catch (Exception e) {
			FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME + " has had a problem loading its configuration");
		} finally {
			configuration.save();
		}
	}

	public static void set(String categoryName, String propertyName, String newValue) {

		configuration.load();
		if (configuration.getCategoryNames().contains(categoryName)) {
			if (configuration.getCategory(categoryName).containsKey(propertyName)) {
				configuration.getCategory(categoryName).get(propertyName).set(newValue);
			}
		}
		configuration.save();
	}
}
