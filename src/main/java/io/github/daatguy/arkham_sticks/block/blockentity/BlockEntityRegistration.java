package io.github.daatguy.arkham_sticks.block.blockentity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.Registration;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class BlockEntityRegistration {

	private String id;
	private BlockEntityType<BlockEntity> blockEntityType;
	private final Factory<BlockEntity> blockEntityFactory;
	private final Block block;
	
	public BlockEntityRegistration(String idIn, 
			Factory<BlockEntity> blockEntityFactory, 
			Block blockIn) {
		this.id = idIn;
		this.blockEntityFactory = blockEntityFactory;
	    this.block = blockIn;
	    this.blockEntityType = null;
	}
	
	/*public Factory<? extends BlockEntity> getBlockEntity() {
		return this.blockEntity;
	}*/
	
	public Block getBlock() {
		return this.block;
	}
	
	public BlockEntityType<BlockEntity> getBlockEntityType() {
		if(blockEntityType == null) throw new IllegalArgumentException("getEntry() " +
	                                "called prior to BlockEntityType registration for " +
				                    Mod.ID + ":" + this.id + ".");
		return blockEntityType;
	}
	
	public void register() {
		blockEntityType = Registry.register(
				Registry.BLOCK_ENTITY_TYPE, 
				Mod.ID + ":" + this.id, 
				FabricBlockEntityTypeBuilder.create(blockEntityFactory, 
						this.block).build(null));
	}

}
