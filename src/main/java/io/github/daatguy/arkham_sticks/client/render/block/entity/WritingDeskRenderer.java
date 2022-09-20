package io.github.daatguy.arkham_sticks.client.render.block.entity;

import io.github.daatguy.arkham_sticks.block.entity.BlockEntityWritingDesk;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;

/**
 * Renders a Writing Desk in the world
 * 
 * @author DaatG
 */
public class WritingDeskRenderer implements BlockEntityRenderer<BlockEntityWritingDesk> {

	public WritingDeskRenderer(BlockEntityRendererFactory.Context ctx) {}
	
	private final double[][] slotPositions = {
			{4.5d / 16d, 12.5d / 16d},
			{5.5d / 16d, 6.5d / 16d},
			{10.5d / 16d, 11.5d / 16d}
	};
	private final double height = 1.01d;
	private final double blockHeight = 1.035d;
	private final float scale = 0.6667f;
	
	private void renderItemStackInSlot(int slot, ItemStack stack, MatrixStack matrices, 
			VertexConsumerProvider vertexConsumers, int light) {
		if(stack.isEmpty()) return;
		matrices.push();
		matrices.translate(slotPositions[slot][0], height, slotPositions[slot][1]);
		matrices.scale(scale, scale, scale);
		matrices.multiply(
				Vec3f.POSITIVE_X.getDegreesQuaternion(90));
		matrices.multiply(
				Vec3f.POSITIVE_Z.getDegreesQuaternion(180));
		MinecraftClient.getInstance().getItemRenderer().renderItem(
				stack, 
				ModelTransformation.Mode.GROUND, 
				light, 
				OverlayTexture.DEFAULT_UV, 
				matrices, 
				vertexConsumers, 
				0);
        matrices.pop();
	}
	
	private void renderBlockItemStackInSlot(int slot, ItemStack stack, 
			MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		if(stack.isEmpty()) return;
		matrices.push();
		matrices.translate(slotPositions[slot][0], blockHeight, slotPositions[slot][1]);
		matrices.scale(scale, scale, scale);
		matrices.multiply(
				Vec3f.POSITIVE_Y.getDegreesQuaternion(180));
		MinecraftClient.getInstance().getItemRenderer().renderItem(
				stack, 
				ModelTransformation.Mode.GROUND, 
				light, 
				OverlayTexture.DEFAULT_UV, 
				matrices, 
				vertexConsumers, 
				0);
        matrices.pop();
	}

	@Override
	public void render(BlockEntityWritingDesk blockEntity,
			float tickDelta, MatrixStack matrices, 
			VertexConsumerProvider vertexConsumers, int light, int overlay) {
		int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(),
				blockEntity.getPos().up());
		for(int i = 0; i < blockEntity.getItems().size(); ++i) {
			if(blockEntity.getStack(i).getItem() instanceof BlockItem) {
				renderBlockItemStackInSlot(i, blockEntity.getStack(i),
						matrices, vertexConsumers, lightAbove);
			} else {
				renderItemStackInSlot(i, blockEntity.getStack(i),
					matrices, vertexConsumers, lightAbove);
			}
		}
	}

}
