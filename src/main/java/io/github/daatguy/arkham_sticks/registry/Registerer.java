package io.github.daatguy.arkham_sticks.registry;

/**
 * An interface to allow for wrapper classes for registry entries or closely
 * associated series's of registry entries.
 * 
 * Intended to be used so that registration hooks with the Fabric API can
 * be put in register() and then later called as part of a {@link ModRegistry}.
 * 
 * @author DaatG
 */
public interface Registerer {

	/** Register this entry */
	public abstract void register();
	
}
