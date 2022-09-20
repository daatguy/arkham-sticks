package io.github.daatguy.arkham_sticks.client.gui;

import io.github.daatguy.arkham_sticks.ClientMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

/**
 * ScreenHandler implementation for creating and synchronizing new Writing Desk GUIs
 * 
 * @author DaatG
 */
public class WritingDeskScreenHandler extends ScreenHandler {

	private static final int SLOTS = 3;
    private final Inventory inventory;
    
    /**
     * From {@link https://fabricmc.net/wiki/tutorial:screenhandler#screenhandler_and_screen}:
     * 
     *   This constructor gets called on the client when the server wants it to open 
     *   the screenHandler, The client will call the other constructor with an empty 
     *   Inventory and the screenHandler will automatically sync this empty inventory
     *   with the inventory on the server.
     * 
     * Should probably only be called from the fabric API side of things.
     * 
     * @param syncId          the synchronization ID
     * @param playerInventory the player's inventory (to populate the GUI)
     */
    public WritingDeskScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(SLOTS));
    }
 
    /**
     * From {@link https://fabricmc.net/wiki/tutorial:screenhandler#screenhandler_and_screen}:
     * 
     *   This constructor gets called from the BlockEntity on the server without 
     *   calling the other constructor first, the server knows the inventory of the 
     *   container and can therefore directly provide it as an argument. 
     *   This inventory will then be synced to the client.
     *
     * Should probably only be called from the fabric API side of things.
     * 
     * @param syncId          the synchronization ID
     * @param playerInventory the player's inventory (to populate the GUI)
     * @param inventory       the inventory of the writing desk (to populate the GUI)
     */
    public WritingDeskScreenHandler(int syncId, PlayerInventory playerInventory, 
    		Inventory inventory) {
        super(ClientMod.SCREENS.WRITING_DESK.getScreenHandlerType(), syncId);
        checkSize(inventory, SLOTS);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

		int index = 0;
		// TODO: This is for crafting results or when the ghost slot behavior gets
		// re-added
		//this.addSlot(new SlotDeskCrafting(playerInventory.player,
		//		this.craftMatrix, this.craftResult, 0, 116, 35, this));
		this.addSlot(new Slot(inventory, index++, 48, 25));
		this.addSlot(new Slot(inventory, index++, 39, 43));
		this.addSlot(new Slot(inventory, index++, 57, 43));
		// addSlotToContainer(outputSlot);

		// Main player inventory
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlot(new Slot(playerInventory, x + (y * 9) + 9,
						8 + x * 18, 84 + 8 + 18 * y));
			}
		}

		// Player hotbar inventory
		for (int x = 0; x < 9; x++) {
			addSlot(new Slot(playerInventory, x, 8 + x * 18, 142 + 8));
		}
    }
 
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
 
    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }
 
            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
 
        return newStack;
    }

}
