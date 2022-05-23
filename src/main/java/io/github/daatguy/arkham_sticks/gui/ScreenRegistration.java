package io.github.daatguy.arkham_sticks.gui;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.HandledScreens.Provider;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType.Factory;
import net.minecraft.util.registry.Registry;

public class ScreenRegistration<T extends ScreenHandler, U extends HandledScreen<T>> 
extends Registration {

	private final Factory<T> factory;
	private final Provider<T, U> provider;
	private ScreenHandlerType<T> type;
	
	public ScreenRegistration(String idIn, Factory<T> factoryIn,
			Provider<T, U> providerIn) {
		super(idIn);
		this.factory = factoryIn;
		this.provider = providerIn;
		this.type = null;
	}
	
	public ScreenHandlerType<T> getScreenHandlerType() {
		if(type == null) throw new IllegalArgumentException("getScreenHandlerType() " +
	                                "called prior to ScreenHandlerType registration " +
				                    "for " + Mod.ID + ":" + getID() + ".");
		return type;
	}
	
	public Factory<T> getFactory() {
		return this.factory;
	}
	
	public Provider<T, U> getProvider() {
		return this.provider;
	}
	
	@Override
	public void register() {
		type = Registry.register(
				Registry.SCREEN_HANDLER, 
				getID(), 
				new ScreenHandlerType<T>(factory));
    	HandledScreens.register(type, provider);
	}
	
}
