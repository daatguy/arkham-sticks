package io.github.daatguy.arkham_sticks.blockentity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.ModRegistry;

public class ModBlockEntities extends ModRegistry {
	
	public final BlockEntityRegistration WRITING_DESK = add(
			new BlockEntityRegistration(
					"writing_desk_block_entity",
					BlockEntityWritingDesk::new,
					Mod.BLOCKS.WRITING_DESK.getBlock()
					));
}
