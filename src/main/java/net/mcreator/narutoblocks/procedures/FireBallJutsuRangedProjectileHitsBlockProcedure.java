package net.mcreator.narutoblocks.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.narutoblocks.network.NarutoblocksModVariables;
import net.mcreator.narutoblocks.NarutoblocksMod;

public class FireBallJutsuRangedProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		int horizontalRadiusSphere = (int) ((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).JutsuMastery / 4) - 1;
		int verticalRadiusSphere = (int) ((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).JutsuMastery / 4) - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if (!((world.getBlockState(new BlockPos(x + xi, y + i, z + zi))).getBlock() == Blocks.AIR)) {
							world.setBlock(new BlockPos(x, y + 1, z), Blocks.FIRE.defaultBlockState(), 3);
							world.levelEvent(2001, new BlockPos(x + xi, y + i, z + zi), Block.getId((world.getBlockState(new BlockPos(x + xi, y + i, z + zi)))));
						}
					}
				}
			}
		}
		if ((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).JutsuMastery >= 20) {
			{
				// Get the radius of the sphere
				double radius = 1; // 3 blocks
				// Set the tolerance for how close to the surface a point must be to create a particle
				double tolerance = 0.15; // 0.1 blocks
				for (double xx = -radius; xx <= radius; xx += 0.1) {
					for (double yy = -radius; yy <= radius; yy += 0.1) {
						for (double zz = -radius; zz <= radius; zz += 0.1) {
							if (Math.abs(xx * xx + yy * yy + zz * zz - radius * radius) <= tolerance) {
								// Calculate the position of the particle
								double posX = x + xx;
								double posY = y + yy;
								double posZ = z + zz;
								if (true) {
									if (world instanceof ServerLevel)
										((ServerLevel) world).sendParticles(ParticleTypes.EXPLOSION, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
								} else {
									world.addParticle(ParticleTypes.EXPLOSION, posX, posY, posZ, 0, 0, 0);
								}
							}
						}
					}
				}
			}
			NarutoblocksMod.queueServerWork(1, () -> {
				{
					// Get the radius of the sphere
					double radius = 2; // 3 blocks
					// Set the tolerance for how close to the surface a point must be to create a particle
					double tolerance = 0.15; // 0.1 blocks
					for (double xx = -radius; xx <= radius; xx += 0.1) {
						for (double yy = -radius; yy <= radius; yy += 0.1) {
							for (double zz = -radius; zz <= radius; zz += 0.1) {
								if (Math.abs(xx * xx + yy * yy + zz * zz - radius * radius) <= tolerance) {
									// Calculate the position of the particle
									double posX = x + xx;
									double posY = y + yy;
									double posZ = z + zz;
									if (true) {
										if (world instanceof ServerLevel)
											((ServerLevel) world).sendParticles(ParticleTypes.EXPLOSION, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
									} else {
										world.addParticle(ParticleTypes.EXPLOSION, posX, posY, posZ, 0, 0, 0);
									}
								}
							}
						}
					}
				}
				NarutoblocksMod.queueServerWork(1, () -> {
					{
						// Get the radius of the sphere
						double radius = 3; // 3 blocks
						// Set the tolerance for how close to the surface a point must be to create a particle
						double tolerance = 0.15; // 0.1 blocks
						for (double xx = -radius; xx <= radius; xx += 0.1) {
							for (double yy = -radius; yy <= radius; yy += 0.1) {
								for (double zz = -radius; zz <= radius; zz += 0.1) {
									if (Math.abs(xx * xx + yy * yy + zz * zz - radius * radius) <= tolerance) {
										// Calculate the position of the particle
										double posX = x + xx;
										double posY = y + yy;
										double posZ = z + zz;
										if (true) {
											if (world instanceof ServerLevel)
												((ServerLevel) world).sendParticles(ParticleTypes.EXPLOSION, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
										} else {
											world.addParticle(ParticleTypes.EXPLOSION, posX, posY, posZ, 0, 0, 0);
										}
									}
								}
							}
						}
					}
					NarutoblocksMod.queueServerWork(1, () -> {
						{
							// Get the radius of the sphere
							double radius = 4; // 3 blocks
							// Set the tolerance for how close to the surface a point must be to create a particle
							double tolerance = 0.15; // 0.1 blocks
							for (double xx = -radius; xx <= radius; xx += 0.1) {
								for (double yy = -radius; yy <= radius; yy += 0.1) {
									for (double zz = -radius; zz <= radius; zz += 0.1) {
										if (Math.abs(xx * xx + yy * yy + zz * zz - radius * radius) <= tolerance) {
											// Calculate the position of the particle
											double posX = x + xx;
											double posY = y + yy;
											double posZ = z + zz;
											if (true) {
												if (world instanceof ServerLevel)
													((ServerLevel) world).sendParticles(ParticleTypes.EXPLOSION, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
											} else {
												world.addParticle(ParticleTypes.EXPLOSION, posX, posY, posZ, 0, 0, 0);
											}
										}
									}
								}
							}
						}
					});
				});
			});
		}
	}
}
