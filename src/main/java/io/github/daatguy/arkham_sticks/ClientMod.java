package io.github.daatguy.arkham_sticks;

import io.github.daatguy.arkham_sticks.client.gui.ModScreens;
import io.github.daatguy.arkham_sticks.client.render.block.entity.ModBlockEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Initializes all client-side things of the mod, holds all the client-side registries.
 * 
 * @author DaatG
 */
@Environment(EnvType.CLIENT)
public class ClientMod implements ClientModInitializer {
	
	public static final ModScreens SCREENS = new ModScreens();
	public static final ModBlockEntityRenderers BLOCK_ENTITY_RENDERERS = 
			new ModBlockEntityRenderers();
	
    @Override
    public void onInitializeClient() {
    	BLOCK_ENTITY_RENDERERS.register();
    	SCREENS.register();
    }
}

