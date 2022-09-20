package io.github.daatguy.arkham_sticks.item;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * A registration entry of an item in the Mod
 * 
 * @author DaatG
 */
public class ItemRegistration extends Registration {

	private final Item item;
	
	/**
	 * Constructs a new registry entry
	 * 
	 * @param idIn   the string id of the item (Mod.ID excluded,
	 *               don't do "xyzmod:red_ball")
	 * @param itemIn the item to register
	 */
	public ItemRegistration(String idIn, Item itemIn) {
		super(idIn);
		this.item = itemIn;
	}
	
	/**
	 * Returns the registered item
	 * 
	 * @return the registered item
	 */
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
