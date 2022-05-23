// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.item;

import io.github.daatguy.arkham_sticks.registry.ModRegistry;
import net.minecraft.item.ItemGroup;

public class ModItems extends ModRegistry {

	public final ItemRegistration SEPULCHRAL_DUST = add(
			new ItemRegistration("sepulchral_dust", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration SEPULCHRAL_SHARDS = add(
            new ItemRegistration("sepulchral_shards", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration MAGNIFYING_GLASS = add(
			new ItemRegistration("magnifying_glass", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration MUMMY_CHUNK = add(
			new ItemRegistration("mummy_chunk", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration MUMMY_DUST = add(
			new ItemRegistration("mummy_dust", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration FLESH_CHUNK = add(
			new ItemRegistration("flesh_chunk", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration FLESH_PASTE = add(
			new ItemRegistration("flesh_paste", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration FOSSIL_DUST = add(
			new ItemRegistration("fossil_dust", new ModItem(ItemGroup.MISC)));
	public final ItemRegistration FOSSIL_KNIFE = add(
			new ItemRegistration("fossil_knife", new FossilKnife()));

}
