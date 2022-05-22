// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;

public class ModBlock extends Block {

	/** This block's id in the block registry */
	public final String id;
	/** Whether there is an associated Block Item */
	public final boolean hasItem;
	/** This block's item's inventory group, if applicable */
	public final ItemGroup group;
	
	/**
	 * Constructs a new block in the mod
	 * 
	 * @param settingsIn the Settings for the block
	 * @param idIn       the registry identifier for the block
	 * @param hasItemIn  whether the block has an item
	 * @param groupIn    the group the block item would belong to
	 */
	public ModBlock(Settings settingsIn, String idIn, 
			        boolean hasItemIn, ItemGroup groupIn) {
		super(settingsIn);
		this.id = idIn;
		this.hasItem = hasItemIn;
		this.group = groupIn;
	}
	
	/**
	 * Constructs a new block in the mod with no block item
	 * 
	 * @param settingsIn the Settings for the block
	 * @param idIn       the registry identifier for the block
	 */
	public ModBlock(Settings settingsIn, String idIn) {
		this(settingsIn, idIn, false, (ItemGroup)null);
	}

}
