package io.github.daatguy.arkham_sticks.client.render.block.entity;

import io.github.daatguy.arkham_sticks.registry.Registerer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class BERendererRegistration<E extends BlockEntity> implements Registerer {

	private final BlockEntityType<E> type;
	private final BlockEntityRendererFactory<? super E> factory;

	public BERendererRegistration(BlockEntityType<E> type, 
			BlockEntityRendererFactory<? super E> factory) {
		this.type = type;
		this.factory = factory;
	}
	
	public BlockEntityType<E> getType() {
		return this.type;
	}
	
	public BlockEntityRendererFactory<? super E> getFactory() {
		return this.factory;
	}

	@Override
	public void register() {
		BlockEntityRendererRegistry.register(type, factory);
	}

}
