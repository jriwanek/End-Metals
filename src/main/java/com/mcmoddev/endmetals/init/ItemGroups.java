package com.mcmoddev.endmetals.init;

import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.data.SharedStrings;
import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.lib.material.MMDMaterial;

/**
 * This class initializes all item groups in End Metals.
 *
 * @author Jasmine Iwanek
 *
 */
public final class ItemGroups extends com.mcmoddev.lib.init.ItemGroups {

	private ItemGroups() {
		throw new IllegalAccessError(SharedStrings.NOT_INSTANTIABLE);
	}

	/**
	 *
	 * @param materialName The name of the material.
	 */
	public static void setupIcons(final String materialName) {
		if (Materials.hasMaterial(materialName)) {
			final MMDMaterial material = Materials.getMaterialByName(materialName);

			if (material.hasBlock(Names.ENDORE)) {
				getTab(EndMetals.MODID, SharedStrings.TAB_BLOCKS).setTabIconItem(material.getBlock(Names.ENDORE));
			}
		}
	}
}
