// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.block;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	private static final ArrayList<ModBlock> modBlocks = new ArrayList<ModBlock>();

	/** Sepulchral bricks */
	public static final ModBlock SEPULCHRAL_BRICKS = add(new SepulchralBricks());

	/** Adds an item instance to our list of items */
	private static ModBlock add(ModBlock in) {
		modBlocks.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the items in the mod to Minecraft's registry */
	public static void register() {
		for(ModBlock block : modBlocks) {
			Registry.register(Registry.BLOCK,                   // Add to block registry
					          new Identifier(Mod.ID, block.id), // (with the item's id)
					          block);                           // the item
			if(!block.hasItem) continue;
			FabricItemSettings settings = new FabricItemSettings();
			if(block.group != null) settings.group(block.group);
			Registry.register(Registry.ITEM, 
					          new Identifier(Mod.ID, block.id), 
					          new BlockItem(block, settings));
		}
	}

}
