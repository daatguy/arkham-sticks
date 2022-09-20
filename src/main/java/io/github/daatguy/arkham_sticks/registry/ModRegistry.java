package io.github.daatguy.arkham_sticks.registry;

import java.util.ArrayList;

/**
 * An abstract class for handling different registries in the mod.
 * These are easily all registerable in sequence in the main class's
 * initialization steps, without having a bunch of boilerplate.
 * 
 * @author DaatG
 */
public abstract class ModRegistry {
	
	/** The list of entries in this registry*/
	public ArrayList<Registerer> entries = new ArrayList<Registerer>();
	
	/**
	 * Adds an entry to our list of entries
	 * 
	 * @param in the entry to add
	 */
	public <T extends Registerer> T add(T in) {
		entries.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the entries in this registry*/
	public void register() {
		for(Registerer item : entries) {
			item.register();
		}
	}
	
}
