package io.github.daatguy.arkham_sticks.sound;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.registry.Registration;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundEventRegistration extends Registration {

	private final SoundEvent soundEvent;
	
	public SoundEventRegistration(String idIn) {
		super(idIn);
		this.soundEvent = new SoundEvent(new Identifier(Mod.ID, idIn));
	}
	
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public void register() {
		Registry.register(Registry.SOUND_EVENT, // Add to sound event registry
		          getID(),                      // (with the sound event's id)
		          getSoundEvent());             // the sound event

	}

}
