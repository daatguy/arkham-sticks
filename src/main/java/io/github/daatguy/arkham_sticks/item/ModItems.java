// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.item;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.Registration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

	private static final ArrayList<Registration<Item>> modItems =
			new ArrayList<Registration<Item>>();

	public static final Registration<Item> SEPULCHRAL_DUST = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "sepulchral_dust"));
	public static final Registration<Item> SEPULCHRAL_SHARDS = add(
            new Registration<Item>(new ModItem(ItemGroup.MISC), "sepulchral_shards"));
	public static final Registration<Item> MAGNIFYING_GLASS = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "magnifying_glass"));
	public static final Registration<Item> MUMMY_CHUNK = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "mummy_chunk"));
	public static final Registration<Item> MUMMY_DUST = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "mummy_dust"));
	public static final Registration<Item> FLESH_CHUNK = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "flesh_chunk"));
	public static final Registration<Item> FLESH_PASTE = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "flesh_paste"));
	public static final Registration<Item> FOSSIL_DUST = add(
			new Registration<Item>(new ModItem(ItemGroup.MISC), "fossil_dust"));
	public static final Registration<Item> FOSSIL_KNIFE = add(
			new Registration<Item>(new FossilKnife(), "fossil_knife"));

	/** Adds an item instance to our list of items */
	private static Registration<Item> add(Registration<Item> in) {
		modItems.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the items in the mod to Minecraft's registry */
	public static void register() {
		for(Registration<Item> item : modItems) {
			Registry.register(Registry.ITEM,                   // Add to item registry
					          new Identifier(Mod.ID, item.getID()), // with the ID
					          item.getEntry());                 // the item
		}
	}

}
