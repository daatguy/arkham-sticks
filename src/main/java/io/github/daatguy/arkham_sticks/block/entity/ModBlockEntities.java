package io.github.daatguy.arkham_sticks.block.entity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.ModRegistry;

/**
 * The Registry instance for this Mod's BlockEntities
 * 
 * @author DaatG
 */
public class ModBlockEntities extends ModRegistry {
	
	public final BlockEntityRegistration<BlockEntityWritingDesk> WRITING_DESK = add(
			new BlockEntityRegistration<BlockEntityWritingDesk>(
					"writing_desk_block_entity",
					BlockEntityWritingDesk::new,
					Mod.BLOCKS.WRITING_DESK.getBlock()
					));
}
