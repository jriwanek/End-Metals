package com.mcmoddev.endmetals.integration.plugins;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.util.ConfigBase.Options;

/**
 *
 * @author Jasmine Iwanek
 *
 */
@MMDPlugin(addonId = EndMetals.MODID, pluginId = TinkersConstruct.PLUGIN_MODID)
public class TinkersConstruct extends com.mcmoddev.lib.integration.plugins.TinkersConstructBase implements IIntegration {

	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		registerExtraMeltingWrapper("coal");
		registerExtraMeltingWrapper("diamond");
		registerExtraMeltingWrapper("emerald");
		registerExtraMeltingWrapper("gold");
		registerExtraMeltingWrapper("iron");
		registerExtraMeltingWrapper("lapis");
		registerExtraMeltingWrapper("redstone");

		registerExtraMeltingWrapper("antimony");
		registerExtraMeltingWrapper("bismuth");
		registerExtraMeltingWrapper("copper");
		registerExtraMeltingWrapper("lead");
		registerExtraMeltingWrapper("mercury");
		registerExtraMeltingWrapper("nickel");
		registerExtraMeltingWrapper("platinum");
		registerExtraMeltingWrapper("silver");
		registerExtraMeltingWrapper("tin");
		registerExtraMeltingWrapper("zinc");

		registerExtraMeltingWrapper("aluminum");
		registerExtraMeltingWrapper("cadmium");
		registerExtraMeltingWrapper("chromium");
		registerExtraMeltingWrapper("iridium");
		registerExtraMeltingWrapper("magnesium");
		registerExtraMeltingWrapper("manganese");
		registerExtraMeltingWrapper("osmium");
		registerExtraMeltingWrapper("plutonium");
		registerExtraMeltingWrapper("rutile");
		registerExtraMeltingWrapper("tantalum");
		registerExtraMeltingWrapper("titanium");
		registerExtraMeltingWrapper("tungsten");
		registerExtraMeltingWrapper("uranium");
		registerExtraMeltingWrapper("zirconium");
	}

	private static void registerExtraMeltingWrapper(String materialName) {
		registerExtraMelting(materialName, Names.ENDORE.toString(), materialName, 144);
	}
}
