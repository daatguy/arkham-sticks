package io.github.daatguy.arkham_sticks.block;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistration extends Registration {

	private final Block block;
	private final boolean hasItem;
	private final ItemGroup group;
	
	/**
	 * Constructs a new registry entry of a block
	 * 
	 * @param blockIn   the block to be registered
	 * @param idIn      the registry id of the block
	 * @param hasItemIn whether the block has a block item
	 * @param groupIn   the item group (nullable)
	 * @throw IllegalArgumentException if the block has no item but
	 *                                 is put into an ItemGroup
	 */
	public BlockRegistration(Block blockIn, String idIn, 
			boolean hasItemIn, ItemGroup groupIn) {
		super(idIn);
		if(!hasItemIn && groupIn != null) {
			throw new IllegalArgumentException("Block registered with no item in " +
		                                       "item group " + groupIn.getName());
		}
		this.block = blockIn;
		this.hasItem = hasItemIn;
		this.group = groupIn;
	}
	
	/**
	 * Constructs a new registry entry of a block
	 * 
	 * @param blockIn   the block to be registered
	 * @param idIn      the registry id of the block
	 * @param groupIn   the item group (nullable)
	 */
	public BlockRegistration(Block blockIn, String idIn, ItemGroup groupIn) {
		this(blockIn, idIn, groupIn != null, groupIn);
	}
	
	/**
	 * Constructs a new registry entry of a block without a block item
	 * 
	 * @param blockIn the block to be registered
	 * @param idIn    the registry id of the block
	 */
	public BlockRegistration(Block blockIn, String idIn) {
		this(blockIn, idIn, false, null);
	}
	
	public Block getBlock() {
		return this.block;
	}
	
	public boolean hasItem() {
		return this.hasItem;
	}
	
	public ItemGroup getItemGroup() {
		return this.group;
	}

	@Override
	public void register() {
		Registry.register(Registry.BLOCK, // Add to block registry
				new Identifier(Mod.ID, getID()), // (with the block's id)
				getBlock()); // the block
		if (!hasItem()) return;
		FabricItemSettings settings = new FabricItemSettings();
		if (getItemGroup() != null) settings.group(getItemGroup());
		Registry.register(Registry.ITEM, 
				new Identifier(Mod.ID, getID()), 
				new BlockItem(getBlock(), settings));
	}

}
