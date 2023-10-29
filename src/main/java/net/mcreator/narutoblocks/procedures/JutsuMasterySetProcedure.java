package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class JutsuMasterySetProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
