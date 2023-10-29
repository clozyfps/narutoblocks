package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FireBallJutsuRangedWhileProjectileFlyingTickProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
{
// Get the radius of the sphere
double radius = (/ 6.5); // 3 blocks
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
((ServerLevel) world).sendParticles(ParticleTypes.FLAME, posX, posY, posZ, (int) 1, 0.01, 0.01, 0.01, 0);
} else {
world.addParticle(ParticleTypes.FLAME, posX, posY, posZ, 0, 0, 0);
}
}
}
}
}
}if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 5, 1, 2, 1, 0);
}
}
