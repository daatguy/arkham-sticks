package io.github.daatguy.arkham_sticks.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockWritingDesk extends Block {

	//private static final Text TITLE = new TranslatableText("container.test_crafting");

	public BlockWritingDesk() {
		super(FabricBlockSettings.of(Material.WOOD).strength(2.5f));
	}
	
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, 
			PlayerEntity player, Hand hand, BlockHitResult hit) {
		if(world.isClient) return ActionResult.SUCCESS;
		player.openHandledScreen(state.createScreenHandlerFactory(world, pos));
		//player.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
		return ActionResult.CONSUME;
	}
 
	/*@Override
	public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
		return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
			return new WritingDeskScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
		}, TITLE);
	}*/
}

