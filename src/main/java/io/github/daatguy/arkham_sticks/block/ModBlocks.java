// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.block;

import io.github.daatguy.arkham_sticks.registry.ModRegistry;
import net.minecraft.item.ItemGroup;

/**
 * The Registry instance for this Mod's blocks
 * 
 * @author DaatG
 */
public class ModBlocks extends ModRegistry {
	
	public final BlockRegistration SEPULCHRAL_BRICKS = add(
			new BlockRegistration(
					new BlockSepulchralBricks(), 
					"sepulchral_bricks",
					ItemGroup.BUILDING_BLOCKS));
	public final BlockRegistration WRITING_DESK = add(
			new BlockRegistration(
					new BlockWritingDesk(),
					"writing_desk",
					ItemGroup.DECORATIONS));

}
