// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.block;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

	private static final ArrayList<BlockRegistration> modBlocks = 
			new ArrayList<BlockRegistration>();

	public static final BlockRegistration SEPULCHRAL_BRICKS = add(
			new BlockRegistration(
					new BlockSepulchralBricks(), 
					"sepulchral_bricks",
					ItemGroup.BUILDING_BLOCKS));
	public static final BlockRegistration WRITING_DESK = add(
			new BlockRegistration(
					new BlockWritingDesk(),
					"writing_desk",
					ItemGroup.DECORATIONS));

	/** Adds an block instance to our list of blocks */
	private static BlockRegistration add(BlockRegistration in) {
		modBlocks.add(in); // Keep track off all our blocks in a list
		return in;
	}

	/** Registers all the block in the mod to Minecraft's registry */
	public static void register() {
		for (BlockRegistration block : modBlocks) {
			Registry.register(Registry.BLOCK, // Add to block registry
					new Identifier(Mod.ID, block.getID()), // (with the item's id)
					block.getEntry()); // the item
			if (!block.hasItem())
				continue;
			FabricItemSettings settings = new FabricItemSettings();
			if (block.getItemGroup() != null)
				settings.group(block.getItemGroup());
			Registry.register(Registry.ITEM, 
					new Identifier(Mod.ID, block.getID()), 
					new BlockItem(block.getEntry(), settings));
		}
	}

}
