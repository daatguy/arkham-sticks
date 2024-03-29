package io.github.daatguy.arkham_sticks.client.gui;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.gui.screen.ingame.HandledScreens.Provider;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.ScreenHandlerType.Factory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * A single Screen's registry entry
 * 
 * @author DaatG
 *
 * @param <T> The ScreenHandler class in the fabric UI framework
 * @param <U> The Screen class to associate with the ScreenHandler
 */
public class ScreenRegistration<T extends ScreenHandler, U extends HandledScreen<T>> 
	extends Registration {

	private final Factory<T> factory;
	private final Provider<T, U> provider;
	private ScreenHandlerType<T> type;
	
	/**
	 * Instantiates a new ScreenRegistration instance
	 * 
	 * @param idIn       the string ID of this ScreenRegistration (MOD ID EXLCUDED)
	 * @param factoryIn  the ScreenHandler factory
	 * @param providerIn the Provider instance that associates ScreenHandlers and Screens
	 */
	public ScreenRegistration(String idIn, Factory<T> factoryIn,
			Provider<T, U> providerIn) {
		super(idIn);
		this.factory = factoryIn;
		this.provider = providerIn;
		this.type = null;
	}
	
	/**
	 * Returns the type of the ScreenHandler associated with this registry entry
	 * 
	 * @return the type of the ScreenHandler associated with this registry entry
	 * @throws IllegalStateException if this hasn't been registered yet
	 */
	public ScreenHandlerType<T> getScreenHandlerType() {
		if(type == null) throw new IllegalStateException("getScreenHandlerType() " +
	                                "called prior to ScreenHandlerType registration " +
				                    "for " + Mod.ID + ":" + getID() + ".");
		return type;
	}
	
	/**
	 * Returns the factory associated with this registry entry
	 * 
	 * @return the factory associated with this registry entry
	 */
	public Factory<T> getFactory() {
		return this.factory;
	}
	
	/**
	 * Returns the Provider instance that associates ScreenHandlers and Screens
	 * which is associated with this registry entry
	 * 
	 * @return the Provider instance that associates ScreenHandlers and Screens
	 *         which is associated with this registry entry
	 */
	public Provider<T, U> getProvider() {
		return this.provider;
	}
	
	@Override
	public void register() {
		type = Registry.register(
				Registry.SCREEN_HANDLER, 
				new Identifier(Mod.ID, getID()), 
				new ScreenHandlerType<T>(factory));
    	HandledScreens.register(type, provider);
	}
	
}
