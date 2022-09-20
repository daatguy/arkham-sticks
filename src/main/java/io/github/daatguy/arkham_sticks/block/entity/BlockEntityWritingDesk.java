package io.github.daatguy.arkham_sticks.block.entity;

import javax.annotation.Nullable;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.client.gui.WritingDeskScreenHandler;
import io.github.daatguy.arkham_sticks.container.ModInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

/**
 * The BlockEntity for a writing desk block
 * 
 * @author DaatG
 */
public class BlockEntityWritingDesk 
	extends BlockEntity 
	implements NamedScreenHandlerFactory, ModInventory {

	private final DefaultedList<ItemStack> items;
	
	/**
	 * Instantiates a new BlockEntityWritingDesk
	 * 
	 * @param pos   the block's position in the world
	 * @param state the BlockState of that block (facing east, west, etc.)
	 */
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
    
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
    }
   
    @Override
    public NbtCompound toInitialChunkDataNbt() {
      return createNbt();
    }
    
    @Override
    public void markDirty() {
    	super.markDirty();
    	//if(world.isClient) return;
    	//((ServerWorld)world).getPlayerManager().sendToAll(pos, getCachedState());
    }
	
}
