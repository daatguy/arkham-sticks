package io.github.daatguy.arkham_sticks.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

/**
 * A custom inventory for the Mod's containers
 * 
 * @author DaatG
 */
public interface ModInventory extends Inventory {

	/** Retrieves the items in the inventory */
	public DefaultedList<ItemStack> getItems();

	/**
	 * Creates an inventory instance of given items
	 * 
	 * @param items the items to include in the inventory
	 * @return the inventory
	 */
	public static ModInventory of(DefaultedList<ItemStack> items) {
		// TODO see if lambda can go (was in API docs, don't exactly know what it does)
		return () -> items;
	}
	
	/**
	 * Creates an empty inventory instance of given size
	 * 
	 * @param size the size of the inventory
	 * @return the inventory
	 */
	public static ModInventory ofSize(int size) {
		return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
	}

	@Override
	public default int size() {
		return getItems().size();
	}
	
	@Override
	public default void clear() {
		getItems().clear();
	}

	@Override
	public default boolean isEmpty() {
		for(int i = 0; i < size(); ++i) {
            if (!getStack(i).isEmpty()) {
                return false;
            }
        }
        return true;
	}

	@Override
	public default ItemStack getStack(int slot) {
		return getItems().get(slot);
	}
	
	/**
	 * Removes a given amount of items from a slot
	 * 
	 * @param slot  the slot to remove from
	 * @param count the count to remove
	 */
	@Override
	public default ItemStack removeStack(int slot, int count) {
		ItemStack out = Inventories.splitStack(getItems(), slot, count);
		if(!out.isEmpty()) markDirty();
		return out;
	}

	/**
	 * Removes all items from a slot
	 * 
	 * @param slot the slot to remove from
	 */
	@Override
	public default ItemStack removeStack(int slot) {
		return Inventories.removeStack(getItems(), slot);
	}

	/**
     * Replaces the current stack in an inventory slot with the provided stack.
     * 
     * @param slot  the inventory slot to replace
     * @param stack the replacing stack (if too big for this inventory, it gets resized)
     */
    @Override
    default void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);
        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }

	/**
	 * Override if you want behavior
	 */
	@Override
	public default void markDirty() {}

	@Override
	public default boolean canPlayerUse(PlayerEntity var1) {
		return true;
	}

}
