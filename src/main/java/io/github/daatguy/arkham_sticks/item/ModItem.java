package io.github.daatguy.arkham_sticks.item;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Language;
import net.minecraft.world.World;

/**
 * An item, with some additional metadata and a custom tooltip
 * 
 * @author daatguy
 */
public class ModItem extends Item {

	/** The item's id */
	public final String id;
	/** The length at which to wrap the tooltip */
	public static int TOOLTIP_CHARACTER_WRAP = 25;
	
	/**
	 * Constructs a new ModItem
	 * @param idIn    the item ID to use in the game registry
	 * @param groupIn the item's inventory group
	 */
	public ModItem(String idIn, ItemGroup groupIn) {
		super(new FabricItemSettings().group(groupIn));
		this.id = idIn;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, 
			                  List<Text> tooltip, TooltipContext context) {
		super.appendTooltip(stack, world, tooltip, context);
		String key = this.getTranslationKey() + ".tooltip";
		// Get the translated tooltip
		Language language = Language.getInstance();
        String translated = language.get(key);
        
        TextColor gray = TextColor.fromFormatting(Formatting.GRAY);

		if(key.equals(translated)) return; // Exit case, no description field
		ArrayList<String> lines = new ArrayList<String>();
		
		String[] words = translated.split("\\s+");
    	String line = "";
	    for(String word : words) {
	    	if(line.length() + word.length() > TOOLTIP_CHARACTER_WRAP) {
	    		Text text = Text.of(line.substring(1));
	    		tooltip.addAll(text.getWithStyle(Style.EMPTY.withColor(gray)));
	    		line = "";
	    	}
	    	line += " " + word;
	    }
		Text text = Text.of(line.substring(1));
		tooltip.addAll(text.getWithStyle(Style.EMPTY.withColor(gray)));
	}
	
}
