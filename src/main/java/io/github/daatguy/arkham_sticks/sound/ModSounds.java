// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks.sound;

import java.util.ArrayList;

import io.github.daatguy.arkham_sticks.Mod;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {

	private static final ArrayList<ModSoundEvent> modSounds = 
			new ArrayList<ModSoundEvent>();

	/** Sepulchral shatter */
	public static final ModSoundEvent SEPULCHRAL_SHATTER = add(
		   new ModSoundEvent("block/sepulchral_shatter"));
	
	/** Adds an instance to our list of soundEvents */
	private static ModSoundEvent add(ModSoundEvent in) {
		modSounds.add(in); // Keep track off all our items in a list
		return in;
	}

	/** Registers all the items in the mod to Minecraft's registry */
	public static void register() {
		for(ModSoundEvent sound : modSounds) {
			Registry.register(Registry.SOUND_EVENT, // Add to sound event registry
					          sound.getId(),        // (with the sound event's id)
					          sound);               // the sound event
		}
	}

}
