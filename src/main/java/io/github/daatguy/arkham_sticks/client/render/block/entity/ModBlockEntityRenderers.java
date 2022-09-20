package io.github.daatguy.arkham_sticks.client.render.block.entity;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.block.entity.BlockEntityWritingDesk;
import io.github.daatguy.arkham_sticks.registry.ModRegistry;

/**
 * The Mod's block entity renderer registry
 * 
 * @author DaatG
 */
public class ModBlockEntityRenderers extends ModRegistry {

	public final BERendererRegistration<BlockEntityWritingDesk> WRITING_DESK = add(
			new BERendererRegistration<BlockEntityWritingDesk>(
					Mod.BLOCK_ENTITIES.WRITING_DESK.getBlockEntityType(),
					WritingDeskRenderer::new));
			
}
