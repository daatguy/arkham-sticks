package io.github.daatguy.arkham_sticks.registry;

/**
 * An abstract class intended to be inherited from for most registry entries.
 * 
 * If you don't need an ID field for your registry entry, use {@link Registerer}.
 * 
 * @author DaatG
 */
public abstract class Registration implements Registerer {

	private final String id;
	
	/**
	 * The most bare-bones type of registry entry, just a string ID.
	 * @param idIn
	 */
	public Registration(String idIn) {
		this.id = idIn;
	}
	
	/**
	 * Returns this registry entry's ID
	 * @return this registry entry's ID
	 */
	public String getID() {
		return this.id;
	}
	
}
