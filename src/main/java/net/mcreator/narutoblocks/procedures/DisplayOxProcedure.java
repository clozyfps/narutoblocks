package net.mcreator.narutoblocks.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.narutoblocks.network.NarutoblocksModVariables;

public class DisplayOxProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean v = false;
		if (((entity.getCapability(NarutoblocksModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new NarutoblocksModVariables.PlayerVariables())).LastPressed).equals("3")) {
			v = true;
		} else {
			v = false;
		}
		return v;
	}
}
