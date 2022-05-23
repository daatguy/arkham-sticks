package io.github.daatguy.arkham_sticks.registry;

import java.util.ArrayList;

public abstract class ModRegistry {
	
	public ArrayList<Registration> entries = new ArrayList<Registration>();
	
	/** Adds an entry to our list of entries */
	public <T extends Registration> T add(T in) {
		entries.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the entries */
	public void register() {
		for(Registration item : entries) {
			item.register();
		}
	}
	
}
