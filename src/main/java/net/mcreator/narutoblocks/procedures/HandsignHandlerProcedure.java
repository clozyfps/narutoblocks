package net.mcreator.narutoblocks.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.narutoblocks.network.NarutoblocksModVariables;

public class HandsignHandlerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Combination).equals("1213")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Fireball"), false);
		} else if (((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Combination).equals("2213")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Water"), false);
		} else if (((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).Combination).equals("121313")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Air"), false);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("Invalid"), false);
		}
		{
			String _setval = "";
			entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.Combination = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "";
			entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LastPressed = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
