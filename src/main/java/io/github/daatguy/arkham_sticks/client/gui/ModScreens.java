package io.github.daatguy.arkham_sticks.client.gui;

import io.github.daatguy.arkham_sticks.client.gui.screen.WritingDeskScreen;
import io.github.daatguy.arkham_sticks.registry.ModRegistry;

public class ModScreens extends ModRegistry {
	
	public final ScreenRegistration<WritingDeskScreenHandler, WritingDeskScreen> 
	WRITING_DESK = add(
			new ScreenRegistration<WritingDeskScreenHandler, WritingDeskScreen>(
					"writing_desk_screen", 
					WritingDeskScreenHandler::new, 
					WritingDeskScreen::new));
	
}
