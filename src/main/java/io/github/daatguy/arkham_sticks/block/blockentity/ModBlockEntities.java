package io.github.daatguy.arkham_sticks.block.blockentity;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.block.ModBlocks;

public class ModBlockEntities {

	private static final ArrayList<BlockEntityRegistration> modBlockEntities = 
			new ArrayList<BlockEntityRegistration>();
	
	public static BlockEntityRegistration WRITING_DESK = add(
			new BlockEntityRegistration(
					"writing_desk_block_entity",
					BlockEntityWritingDesk::new,
					ModBlocks.WRITING_DESK.getEntry()
					));
	
	private static BlockEntityRegistration add(BlockEntityRegistration in) {
		modBlockEntities.add(in); // Keep track off all our items in a list
		return in;
	}

	public static void register() {
		for(BlockEntityRegistration blockEntity : modBlockEntities) {
			blockEntity.register();
		}
	}
}
