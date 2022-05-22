package io.github.daatguy.arkham_sticks.block;

import io.github.daatguy.arkham_sticks.Registration;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public class BlockRegistration extends Registration<Block> {

	private final boolean hasItem;
	private final ItemGroup group;
	
	/**
	 * Constructs a new registry entry of a block
	 * 
	 * @param entryIn   the block to be registered
	 * @param idIn      the registry id of the block
	 * @param hasItemIn whether the block has a block item
	 * @param groupIn   the item group (nullable)
	 * @throw IllegalArgumentException if the block has no item but
	 *                                 is put into an ItemGroup
	 */
	public BlockRegistration(Block entryIn, String idIn, 
			boolean hasItemIn, ItemGroup groupIn) {
		super(entryIn, idIn);
		if(!hasItemIn && groupIn != null) {
			throw new IllegalArgumentException("Block registered with no item in " +
		                                       "item group " + groupIn.getName());
		}
		this.hasItem = hasItemIn;
		this.group = groupIn;
	}
	
	/**
	 * Constructs a new registry entry of a block
	 * 
	 * @param entryIn   the block to be registered
	 * @param idIn      the registry id of the block
	 * @param groupIn   the item group (nullable)
	 */
	public BlockRegistration(Block entryIn, String idIn, ItemGroup groupIn) {
		super(entryIn, idIn);
		this.hasItem = groupIn != null;
		this.group = groupIn;
	}
	
	/**
	 * Constructs a new registry entry of a block without a block item
	 * 
	 * @param entryIn the block to be registered
	 * @param idIn    the registry id of the block
	 */
	public BlockRegistration(Block entryIn, String idIn) {
		super(entryIn, idIn);
		this.hasItem = false;
		this.group = null;
	}
	
	public boolean hasItem() {
		return this.hasItem;
	}
	
	public ItemGroup getItemGroup() {
		return this.group;
	}

}
