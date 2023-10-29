package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HandsignTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("usingHandsign")) {
			if (entity.getPersistentData().getDouble("handsignTimer") > 0) {
				entity.getPersistentData().putDouble("handsignTimer", (entity.getPersistentData().getDouble("handsignTimer") - 1));
			} else {
				entity.getPersistentData().putBoolean("usingHandsign", false);
				HandsignHandlerProcedure.execute(entity);
			}
		}
	}
}
