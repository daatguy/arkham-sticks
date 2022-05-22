package io.github.daatguy.arkham_sticks.sound;

import io.github.daatguy.arkham_sticks.Mod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvent extends SoundEvent {
	
	public final String id;

	public ModSoundEvent(String idIn) {
		super(new Identifier(Mod.ID, idIn));
		this.id = idIn;
	}

}
