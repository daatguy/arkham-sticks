package io.github.daatguy.arkham_sticks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

/**
 * The core Mod class of Arkham Sticks.
 * 
 * Has methods for pre-init, init, post-init, etc. steps of loading Minecraft.
 * Also has a bunch of fields for different items that need static references.
 * 
 * @author daatguy
 */
public class Mod implements ModInitializer {
	
	/** This logger is used to write text to the console and the log file.
	 * It is considered best practice to use your mod id as the logger's name.
	 * That way, it's clear which mod wrote info, warnings, and errors. */
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

    /** A custom item that does literally nothing cool */
    public static final Item CUSTOM_ITEM = 
    	   new Item(new FabricItemSettings().group(ItemGroup.MISC));
 
    /**
     * The Initialization step of mod-loading
     */
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, 
        		          new Identifier("tutorial", "custom_item"), 
        		          CUSTOM_ITEM);
    }
}
