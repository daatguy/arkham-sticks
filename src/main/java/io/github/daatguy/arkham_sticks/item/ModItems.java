// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.item;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.Mod;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	private static final ArrayList<ModItem> modItems = new ArrayList<ModItem>();

	/** Sepulchral dust */
	public static final ModItem SEPULCHRAL_DUST = add(
		                        new ModItem("sepulchral_dust",
				                ItemGroup.MISC));
	/** Sepulchral shards */
	public static final ModItem SEPULCHRAL_SHARDS = add(
		                        new ModItem("sepulchral_shards",
				   	            ItemGroup.MISC));

	/** Adds an item instance to our list of items */
	private static ModItem add(ModItem in) {
		modItems.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the items in the mod to Minecraft's registry */
	public static void register() {
		for(ModItem item : modItems) {
			Registry.register(Registry.ITEM,                   // Add to item registry
					          new Identifier(Mod.ID, item.id), // (with the item's id)
					          item);                           // the item
		}
	}

}
