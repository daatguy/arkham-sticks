package io.github.daatguy.arkham_sticks.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;

public class BlockWritingDesk extends ModBlock {

	public BlockWritingDesk() {
		super(FabricBlockSettings.of(Material.WOOD)
	          .strength(2.5f),
	          true,
	          ItemGroup.DECORATIONS);
	}
	
}
