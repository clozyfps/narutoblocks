
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.narutoblocks.NarutoblocksMod;

public class NarutoblocksModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, NarutoblocksMod.MODID);
	public static final RegistryObject<SimpleParticleType> LOG_HIT_PARTICLE = REGISTRY.register("log_hit_particle", () -> new SimpleParticleType(true));
}
