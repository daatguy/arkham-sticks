package io.github.daatguy.arkham_sticks.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import io.github.daatguy.arkham_sticks.Mod;
import io.github.daatguy.arkham_sticks.client.gui.WritingDeskScreenHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WritingDeskScreen extends HandledScreen<WritingDeskScreenHandler> {
	
    private static final Identifier TEXTURE = new Identifier(Mod.ID, 
    		"textures/gui/container/writing_desk.png");
 
    public WritingDeskScreen(WritingDeskScreenHandler handler, 
    		PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = 176;
        this.playerInventoryTitleY = this.backgroundHeight - 96;
    }
 
    @Override
    protected void drawBackground(MatrixStack matrices, 
    		float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
 
    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
 
    @Override
    protected void init() {
        super.init();
        //titleX = 111;
        titleX = 95;
        titleY = 12;
    }
}

