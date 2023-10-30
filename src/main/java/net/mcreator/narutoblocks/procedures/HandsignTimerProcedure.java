package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HandsignTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("usingHandsign")) {
			if (entity.getPersistentData().getDouble("handsignTimer") > 0) {
				entity.getPersistentData().putDouble("handsignTimer", (entity.getPersistentData().getDouble("handsignTimer") - 1));
			} else {
				entity.getPersistentData().putBoolean("usingHandsign", false);
				HandsignHandlerProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
