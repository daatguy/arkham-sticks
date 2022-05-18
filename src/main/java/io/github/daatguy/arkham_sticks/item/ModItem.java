package io.github.daatguy.arkham_sticks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ModItem extends Item {

	public String id;
	
	public ModItem(String idIn, ItemGroup groupIn) {
		super(new FabricItemSettings().group(groupIn));
		this.id = idIn;
	}

}
