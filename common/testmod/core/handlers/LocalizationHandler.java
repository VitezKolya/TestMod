
package testmod.core.handlers;

import testmod.core.util.LocalizationUtil;
import testmod.lib.Localizations;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LocalizationHandler {
	public static void loadLanguages() {

		for (String localizationFile : Localizations.localFiles) {
			LanguageRegistry.instance().loadLocalization(localizationFile,
					LocalizationUtil.getLocaleFromFileName(localizationFile),
					LocalizationUtil.isXMLLanguageFile(localizationFile));
		}
	}
}
