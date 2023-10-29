
package net.mcreator.narutoblocks.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FireBallJutsuRangedEntity extends AbstractArrow implements ItemSupplier {
	public FireBallJutsuRangedEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(NarutoblocksModEntities.FIRE_BALL_JUTSU_RANGED.get(), world);
	}

	public FireBallJutsuRangedEntity(EntityType<? extends FireBallJutsuRangedEntity> type, Level world) {
		super(type, world);
	}

	public FireBallJutsuRangedEntity(EntityType<? extends FireBallJutsuRangedEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FireBallJutsuRangedEntity(EntityType<? extends FireBallJutsuRangedEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(Blocks.AIR);
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		FireBallJutsuRangedProjectileHitsBlockProcedure.execute(this.level, blockHitResult.getBlockPos().getX(), blockHitResult.getBlockPos().getY(), blockHitResult.getBlockPos().getZ());
	}

	@Override
	public void tick() {
		super.tick();
		FireBallJutsuRangedWhileProjectileFlyingTickProcedure.execute(this.level, this.getX(), this.getY(), this.getZ());
		if (this.inGround)
			this.discard();
	}

	public static FireBallJutsuRangedEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		FireBallJutsuRangedEntity entityarrow = new FireBallJutsuRangedEntity(NarutoblocksModEntities.FIRE_BALL_JUTSU_RANGED.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static FireBallJutsuRangedEntity shoot(LivingEntity entity, LivingEntity target) {
		FireBallJutsuRangedEntity entityarrow = new FireBallJutsuRangedEntity(NarutoblocksModEntities.FIRE_BALL_JUTSU_RANGED.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(7);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
