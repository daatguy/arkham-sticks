package io.github.daatguy.arkham_sticks.client.render.block.entity;

import io.github.daatguy.arkham_sticks.registry.Registerer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

/**
 * A registry entry for a block entity renderer
 * 
 * @author DaatG
 *
 * @param <E> the BlockEntity associated with this registry entry
 */
public class BERendererRegistration<E extends BlockEntity> implements Registerer {

	private final BlockEntityType<E> type;
	private final BlockEntityRendererFactory<? super E> factory;

	/**
	 * Instantiates a new BERendererRegistration
	 * 
	 * @param type    the registered BlockEntityType<E>,
	 *                where E is our associated BlockEntity
	 * @param factory the registered BlockEntity's factory
	 */
	public BERendererRegistration(BlockEntityType<E> type, 
			BlockEntityRendererFactory<? super E> factory) {
		this.type = type;
		this.factory = factory;
	}
	
	/**
	 * Returns the registered BlockEntityType<E>, where E is our registered BlockEntity
	 * @return The registered BlockEntityType<E>, where E is our registered BlockEntity
	 */
	public BlockEntityType<E> getType() {
		return this.type;
	}
	
	/**
	 * Returns the registered BlockEntity's factory
	 * @return the registered BlockEntity's factory
	 */
	public BlockEntityRendererFactory<? super E> getFactory() {
		return this.factory;
	}

	@Override
	public void register() {
		BlockEntityRendererRegistry.register(type, factory);
	}

}
