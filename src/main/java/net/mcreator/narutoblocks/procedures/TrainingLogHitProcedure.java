package net.mcreator.narutoblocks.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TrainingLogHitProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		Entity entity = event.getEntity();
		if (event != null && entity != null) {
			execute(event, entity.getLevel(), entity, event.getSource().getDirectEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		execute(null, world, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		if (entity instanceof TrainingLogEntity) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (NarutoblocksModParticleTypes.DELETED_MOD_ELEMENT.get()), (entity.getX()), (entity.getY() + 1.2), (entity.getZ()), 1, 0.1, 0.1, 0.1, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(entity.getX(), entity.getY() + 1.2, entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.break")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY() + 1.2), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.break")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
			if (immediatesourceentity.getPersistentData().getDouble("taijutsugain") >= 7) {
				immediatesourceentity.getPersistentData().putDouble("taijutsugain", 0);
				if (immediatesourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Taijutsu Increased"), false);
			} else if (immediatesourceentity.getPersistentData().getDouble("taijutsugain") < 7) {
				immediatesourceentity.getPersistentData().putDouble("taijutsugain", (immediatesourceentity.getPersistentData().getDouble("taijutsugain") + 1));
			}
		} else {
			if (immediatesourceentity.getPersistentData().getDouble("taijutsugain") >= 7) {
				immediatesourceentity.getPersistentData().putDouble("taijutsugain", 0);
				if (immediatesourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("Taijutsu Increased"), false);
			} else if (immediatesourceentity.getPersistentData().getDouble("taijutsugain") < 7) {
				immediatesourceentity.getPersistentData().putDouble("taijutsugain", (immediatesourceentity.getPersistentData().getDouble("taijutsugain") + 1));
			}
		}
	}
}
