package io.github.daatguy.arkham_sticks.registry;

import java.util.ArrayList;

public abstract class ModRegistry {
	
	public ArrayList<Registerer> entries = new ArrayList<Registerer>();
	
	/** Adds an entry to our list of entries */
	public <T extends Registerer> T add(T in) {
		entries.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the entries */
	public void register() {
		for(Registerer item : entries) {
			item.register();
		}
	}
	
}
