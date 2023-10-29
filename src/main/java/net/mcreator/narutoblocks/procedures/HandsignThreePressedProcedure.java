package net.mcreator.narutoblocks.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.narutoblocks.network.NarutoblocksModVariables;

public class HandsignThreePressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "3";
			entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LastPressed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		entity.getPersistentData().putBoolean("usingHandsign", true);
		entity.getPersistentData().putDouble("handsignTimer", 25);
		if (!((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Combination).isEmpty()) {
			{
				String _setval = (entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Combination + "3";
				entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Combination = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = "3";
				entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Combination = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
