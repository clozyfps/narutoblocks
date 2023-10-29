
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.narutoblocks.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.narutoblocks.client.renderer.TrainingLogRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NarutoblocksModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(NarutoblocksModEntities.FIRE_BALL_JUTSU_RANGED.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(NarutoblocksModEntities.TRAINING_LOG.get(), TrainingLogRenderer::new);
	}
}
