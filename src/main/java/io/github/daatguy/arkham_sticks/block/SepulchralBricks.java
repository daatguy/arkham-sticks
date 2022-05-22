package io.github.daatguy.arkham_sticks.block;

import io.github.daatguy.arkham_sticks.item.ModItems;
import io.github.daatguy.arkham_sticks.sound.ModSounds;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SepulchralBricks extends ModBlock {
	
	public static final String ID = "sepulchral_bricks";

	public SepulchralBricks() {
		super(FabricBlockSettings.of(Material.STONE)
	          .strength(4.0f)
	          .hardness(4.0f)
	          .resistance(18000000.0f),
	          ID,
	          true,
	          ItemGroup.BUILDING_BLOCKS);
	}
	
	@Override
	public void afterBreak(World world, PlayerEntity player, 
			               BlockPos pos, BlockState state, 
			               BlockEntity blockEntity, ItemStack stack) {
        if(!world.isClient) {
			player.incrementStat(Stats.MINED.getOrCreateStat(this));
	        player.addExhaustion(0.005f);
	        world.setBlockState(pos, state);
	        Block.dropStack(world, pos, new ItemStack(ModItems.SEPULCHRAL_SHARDS));
	        world.playSound(null, pos, ModSounds.SEPULCHRAL_SHATTER, 
	        		        SoundCategory.BLOCKS, 1f, 
	        		        MathHelper.nextBetween(world.random, 0.8f, 1.6f));
	        shatterSmoke(world, pos);
        }
	}
	
	private static void shatterSmoke(World world, BlockPos pos) {
		if(!(world instanceof ServerWorld)) return; // Sanity check
		ServerWorld server = (ServerWorld) world;
		for(int i = 0; i < 60; ++i) {
			server.spawnParticles(ParticleTypes.SMOKE,
					          pos.getX() + world.random.nextDouble(), 
					          pos.getY() + world.random.nextDouble(), 
					          pos.getZ() + world.random.nextDouble(),
					          1,
					          world.random.nextDouble() * 0.2D - 0.1D, 
					          0D, 
					          world.random.nextDouble() * 0.2D - 0.1D,
					          world.random.nextDouble() * 0.225D);
		}
		for(int i = 0; i < 30; ++i) {
			server.spawnParticles(ParticleTypes.LARGE_SMOKE,
					          pos.getX() + world.random.nextDouble(), 
					          pos.getY() + world.random.nextDouble(), 
					          pos.getZ() + world.random.nextDouble(),
					          1,
					          world.random.nextDouble() * 0.2D - 0.1D, 
					          0D, 
					          world.random.nextDouble() * 0.2D - 0.1D,
					          world.random.nextDouble() * 0.225D);
		}
	}

}