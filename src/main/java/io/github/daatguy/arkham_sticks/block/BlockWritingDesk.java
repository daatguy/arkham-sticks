package io.github.daatguy.arkham_sticks.block;

import io.github.daatguy.arkham_sticks.blockentity.BlockEntityWritingDesk;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWritingDesk extends BlockWithEntity  implements BlockEntityProvider {

	public BlockWritingDesk() {
		super(FabricBlockSettings.of(Material.WOOD)
				.strength(2.5f)
				.sounds(BlockSoundGroup.WOOD));
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new BlockEntityWritingDesk(pos, state);
	}
	
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, 
			PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(world.isClient) return ActionResult.SUCCESS;
        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);
        
        if (screenHandlerFactory != null) {
            //With this call the server will request the client to open the appropriate Screenhandler
            player.openHandledScreen(screenHandlerFactory);
        }
        return ActionResult.SUCCESS;
	}
	
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BlockEntityWritingDesk) {
                ItemScatterer.spawn(world, pos, (BlockEntityWritingDesk)blockEntity);
                // update comparators
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
 
	/*@Override
	public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
			return new WritingDeskScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
		}, TITLE);
	}*/
}

