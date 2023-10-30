package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.narutoblocks.network.NarutoblocksModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AgilityIncreaseProcedure {
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
		if (entity.getDeltaMovement().x() > 0 || entity.getDeltaMovement().z() > 0) {
			if (entity.getPersistentData().getDouble("agilitygain") >= 1500) {
				{
					double _setval = (entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Agility + 1;
					entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Agility = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.getPersistentData().putDouble("agilitygain", 0);
			} else if (entity.getPersistentData().getDouble("agilitygain") < 1500) {
				entity.getPersistentData().putDouble("agilitygain", (entity.getPersistentData().getDouble("agilitygain") + 1));
			}
		}
	}
}
