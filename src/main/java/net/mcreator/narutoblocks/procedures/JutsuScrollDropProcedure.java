package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JutsuScrollDropProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		ItemStack jutsuname = ItemStack.EMPTY;
		ItemStack v = ItemStack.EMPTY;
		String jutsupicked = "";
		double random = 0;
		if (Math.random() < 0.001) {
			random = Mth.nextInt(RandomSource.create(), 1, 1);
			if (random == 1) {
				jutsupicked = "Fireball Jutsu";
			}
			jutsuname = new ItemStack(NarutoblocksModItems.JUTSU_SCROLL.get());
			(jutsuname).setHoverName(Component.literal((jutsupicked + " Scroll")));
			if (sourceentity instanceof Player _player) {
				ItemStack _setstack = jutsuname;
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
