package io.github.daatguy.arkham_sticks.block.entity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder.Factory;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

/**
 * Describes a registry entry containing data relevant to a BlockEntity
 * 
 * @author DaatG
 *
 * @param <E> The associated BlockEntity to register
 */
public class BlockEntityRegistration<E extends BlockEntity> extends Registration {

	private BlockEntityType<E> blockEntityType;
	private final Factory<E> blockEntityFactory;
	private final Block block;
	
	/**
	 * Instantiates a new BlockEntityRegistration
	 * 
	 * @param idIn               the string ID of this block entity (MOD ID EXLCUDED)
	 * @param blockEntityFactory the block entity's factory
	 * @param blockIn            the block to attach the block entity to
	 */
	public BlockEntityRegistration(String idIn, 
			Factory<E> blockEntityFactory, 
			Block blockIn) {
		super(idIn);
		this.blockEntityFactory = blockEntityFactory;
	    this.block = blockIn;
	    this.blockEntityType = null;
	}
	
	/**
	 * Returns the associated block
	 * 
	 * @return the associated block
	 */
	public Block getBlock() {
		return this.block;
	}
	
	/**
	 * Returns the block entity type
	 * 
	 * @return the block entity type
	 * @throws IllegalStateException if this registry hasn't been registered yet
	 *                               (BlockEntityTypes are created on registration 
	 *                               of a BlockEntity)
	 */
	public BlockEntityType<E> getBlockEntityType() {
		if(blockEntityType == null) throw new IllegalStateException("" +
	                                "getBlockEntityType() called prior to " +
				                    "BlockEntityType registration for " +
				                    Mod.ID + ":" + getID() + ".");
		return blockEntityType;
	}

	@Override
	public void register() {
		blockEntityType = Registry.register(
				Registry.BLOCK_ENTITY_TYPE, 
				Mod.ID + ":" + getID(), 
				FabricBlockEntityTypeBuilder.create(blockEntityFactory, 
						this.block).build(null));
	}

}
