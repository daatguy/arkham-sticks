package io.github.daatguy.arkham_sticks.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;

/**
 * A Fossil Knife! It can stab eldritch beings. Inherits from SwordItem.
 * 
 * @author DaatG
 */
public class FossilKnife extends SwordItem {

	public FossilKnife() {
		super(ToolMaterials.GOLD, 0, 1.6f, 
				new FabricItemSettings().group(ItemGroup.COMBAT));
	}

}
