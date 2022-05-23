package io.github.daatguy.arkham_sticks.blockentity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.container.ModInventory;
import io.github.daatguy.arkham_sticks.gui.WritingDeskScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BlockEntityWritingDesk extends BlockEntity 
implements NamedScreenHandlerFactory, ModInventory{

	private final DefaultedList<ItemStack> items;
	
	public BlockEntityWritingDesk(BlockPos pos, BlockState state) {
        super(Mod.BLOCK_ENTITIES.WRITING_DESK.getBlockEntityType(), pos, state);
        this.items = DefaultedList.ofSize(3, ItemStack.EMPTY);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new WritingDeskScreenHandler(syncId, playerInventory, this);
    }

	@Override
	public Text getDisplayName() {
		return new TranslatableText(getCachedState().getBlock().getTranslationKey());
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return items;
	}
	
	@Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }
 
    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }
	
}
