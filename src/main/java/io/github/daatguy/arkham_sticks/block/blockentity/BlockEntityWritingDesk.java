package io.github.daatguy.arkham_sticks.block.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BlockEntityWritingDesk extends BlockEntity {

	public BlockEntityWritingDesk(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WRITING_DESK.getBlockEntityType(), pos, state);
    }
}
