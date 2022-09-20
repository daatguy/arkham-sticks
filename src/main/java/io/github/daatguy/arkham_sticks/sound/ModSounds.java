// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.sound;

import io.github.daatguy.arkham_sticks.registry.ModRegistry;

/**
 * The mod's sound registry
 * 
 * @author DaatG
 */
public class ModSounds extends ModRegistry {
	
	/** Sepulchral shatter */
	public final SoundEventRegistration SEPULCHRAL_SHATTER = add(
		   new SoundEventRegistration("block/sepulchral_shatter"));

}
