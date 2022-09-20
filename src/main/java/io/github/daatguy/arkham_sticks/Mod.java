// SPDX-License-Identifier: GPL-3.0-or-later WITH GPL-3.0-linking-exception
package io.github.daatguy.arkham_sticks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.daatguy.arkham_sticks.block.ModBlocks;
import io.github.daatguy.arkham_sticks.block.entity.ModBlockEntities;
import io.github.daatguy.arkham_sticks.item.ModItems;
import io.github.daatguy.arkham_sticks.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

/**
 * The core Mod class of Arkham Sticks.
 * 
 * Has methods for pre-init, init, post-init, etc. steps of loading Minecraft.
 * Also has a bunch of fields for different items that need static references.
 * 
 * @author daatguy
 */
public class Mod implements ModInitializer {
	
	/** The modid */
	public static final String ID = "arkham_sticks";
	
	/** This logger is used to write text to the console and the log file.
	 *  It is considered best practice to use your mod id as the logger's name.
	 *  That way, it's clear which mod wrote info, warnings, and errors. */
	public static final Logger LOGGER = LoggerFactory.getLogger(Mod.ID);
	
	public static final ModItems ITEMS = new ModItems();
	public static final ModBlocks BLOCKS = new ModBlocks();
	public static final ModBlockEntities BLOCK_ENTITIES = new ModBlockEntities();
	public static final ModSounds SOUNDS = new ModSounds();
	
    /**
     * The initialization step of mod-loading
     */
    @Override
    public void onInitialize() {
    	ITEMS.register();
    	BLOCKS.register();
    	BLOCK_ENTITIES.register();
    	SOUNDS.register();
    }
}
