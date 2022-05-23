package io.github.daatguy.arkham_sticks;

import io.github.daatguy.arkham_sticks.gui.ModScreens;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ClientMod implements ClientModInitializer {
	
	public static final ModScreens SCREENS = new ModScreens();
	
    @Override
    public void onInitializeClient() {
    	SCREENS.register();
    }
}

