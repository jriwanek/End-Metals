package com.mcmoddev.endmetals.integration.plugins;

import java.util.ArrayList;
import java.util.List;

import com.mcmoddev.lib.init.Materials;
import com.mcmoddev.endmetals.EndMetals;
import com.mcmoddev.lib.data.Names;
import com.mcmoddev.lib.integration.IIntegration;
import com.mcmoddev.lib.integration.MMDPlugin;
import com.mcmoddev.lib.integration.plugins.IC2;
import com.mcmoddev.lib.material.MMDMaterial;
import com.mcmoddev.lib.util.Config.Options;
import com.mcmoddev.lib.util.Oredicts;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@MMDPlugin(addonId = EndMetals.MODID, pluginId = EMeIC2.PLUGIN_MODID)
public final class EMeIC2 extends IC2 implements IIntegration {

	/**
	 *
	 */
	@Override
	public void init() {
		if (!Options.isModEnabled(PLUGIN_MODID)) {
			return;
		}

		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 *
	 * @param event The Event.
	 */
	@SubscribeEvent
	public void regCallback(final RegistryEvent.Register<IRecipe> event) {
		final List<MMDMaterial> materials = new ArrayList<>();

		Materials.getAllMaterials().stream().filter(material -> material.hasBlock(Names.ENDORE)).forEach(materials::add);
		for (final MMDMaterial material : materials) {
			ItemStack output;
			if (material.hasItem(Names.CRUSHED)) {
				output = material.getItemStack(Names.CRUSHED, 4);
			} else if (material.hasItem(Names.POWDER)) {
				output = material.getItemStack(Names.POWDER, 4);
			} else {
				continue;
			}

			addMaceratorRecipe(Oredicts.ORE_END + material.getCapitalizedName(), output);
		}
	}
}
