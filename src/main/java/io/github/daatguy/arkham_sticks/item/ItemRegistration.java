package io.github.daatguy.arkham_sticks.item;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistration extends Registration {

	private final Item item;
	
	public ItemRegistration(String idIn, Item itemIn) {
		super(idIn);
		this.item = itemIn;
	}
	
	public Item getItem() {
		return this.item;
	}

	@Override
	public void register() {
		Registry.register(Registry.ITEM,                   // Add to item registry
				          new Identifier(Mod.ID, getID()), // with the ID
				          getItem());                      // the item
	}

}
