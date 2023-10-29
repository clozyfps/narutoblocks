
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.narutoblocks.client.particle.LogHitParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NarutoblocksModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.register(NarutoblocksModParticleTypes.LOG_HIT_PARTICLE.get(), LogHitParticleParticle::provider);
	}
}
