package io.github.kalishak.entity.passive;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.AquaticLookControl;
import net.minecraft.entity.ai.control.AquaticMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WaterCreatureEntity;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WhaleEntity extends WaterCreatureEntity {
	private static final TrackedData<Integer> SPLASH_TIME = DataTracker.registerData(WhaleEntity.class, TrackedDataHandlerRegistry.INTEGER);
	public static final int TOTAL_AIR_SUPPLY = 4800;
	public static final int SPLASH_TIME_COOLDOWN = 3600;
	public final AnimationState swimAnimationState = new AnimationState();
	public final AnimationState idleAnimationState = new AnimationState();

	public WhaleEntity(EntityType<? extends WaterCreatureEntity> entityType, World world) {
		super(entityType, world);
		this.moveControl = new AquaticMoveControl(this, 85, 10, 0.01F, 0.1F, true);
		this.lookControl = new AquaticLookControl(this, 10);
	}

	@Nullable
	@Override
	public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
		setAir(getMaxAir());
		setPitch(0.0F);

		return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
	}

	@Override
	public boolean canBreatheInWater() {
		return false;
	}

	@Override
	protected void tickWaterBreathingAir(int air) {
	}

	public void setSplashTime(int timeIn) {
		this.dataTracker.set(SPLASH_TIME, timeIn);
	}

	public int getSplashTime() {
		return this.dataTracker.get(SPLASH_TIME);
	}

	@Override
	protected void initDataTracker() {
		super.initDataTracker();
		this.dataTracker.startTracking(SPLASH_TIME, SPLASH_TIME_COOLDOWN);
	}

	@Override
	public void writeCustomDataToNbt(NbtCompound nbt) {
		super.writeCustomDataToNbt(nbt);
		nbt.putInt("SplashTime", getSplashTime());
	}

	@Override
	public void readCustomDataFromNbt(NbtCompound nbt) {
		super.readCustomDataFromNbt(nbt);
		setSplashTime(nbt.getInt("SplashTime"));
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(0, new BreatheAirGoal(this));
		this.goalSelector.add(0, new MoveIntoWaterGoal(this));
		this.goalSelector.add(1, new FleeEntityGoal<>(this, GuardianEntity.class, 8.0F, 1.0, 1.0));
		this.goalSelector.add(1, new FleeEntityGoal<>(this, PlayerEntity.class, 8.0F, 1.0, 1.0));
		this.goalSelector.add(2, new SwimAroundGoal(this, 1.0F, 10));
		this.goalSelector.add(2, new LookAroundGoal(this));
		this.goalSelector.add(4, new LookAtEntityGoal(this, FishEntity.class, 6.0F));
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return MobEntity.createAttributes()
			.add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
			.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8F)
			.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.5);
	}

	@Override
	protected EntityNavigation createNavigation(World world) {
		return new SwimNavigation(this, world);
	}

	@Override
	public int getMaxAir() {
		return TOTAL_AIR_SUPPLY;
	}

	@Override
	protected int getNextAirOnLand(int air) {
		return getMaxAir();
	}

	@Override
	protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 0.5F;
	}

	@Override
	public int getLookPitchSpeed() {
		return 1;
	}

	@Override
	public int getBodyYawSpeed() {
		return 1;
	}

	@Override
	public void tick() {
		super.tick();
		if (isAiDisabled()) {
			setAir(getMaxAir());
		} else {
			if (isOnGround()) {
				this.setVelocity(
					this.getVelocity().add((double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F), 0.5, (double)((this.random.nextFloat() * 2.0F - 1.0F) * 0.2F))
				);
				this.setYaw(this.random.nextFloat() * 360.0F);
				this.setOnGround(false);
				this.velocityDirty = true;
				//TODO add laying code
			}
		}
	}

	@Override
	public void onTrackedDataUpdate(TrackedData<?> data) {
		if (POSE.equals(data)) {
			EntityPose entityPose = getPose();
			if (entityPose == EntityPose.SWIMMING) {
				this.swimAnimationState.restart(this.age);
			} else {
				this.swimAnimationState.stop();
			}

			if (entityPose == EntityPose.USING_TONGUE) {
				this.idleAnimationState.restart(this.age);
			} else {
				this.idleAnimationState.stop();
			}
		}

		super.onTrackedDataUpdate(data);
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.ENTITY_DOLPHIN_HURT;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_DOLPHIN_DEATH;
	}

	@Nullable
	@Override
	protected SoundEvent getAmbientSound() {
		return this.isTouchingWater() ? SoundEvents.ENTITY_DOLPHIN_AMBIENT_WATER : SoundEvents.ENTITY_DOLPHIN_AMBIENT;
	}

	@Override
	protected SoundEvent getSplashSound() {
		return SoundEvents.ENTITY_DOLPHIN_SPLASH;
	}

	@Override
	protected SoundEvent getSwimSound() {
		return SoundEvents.ENTITY_DOLPHIN_SWIM;
	}

	protected boolean isNearTarget() {
		BlockPos blockPos = this.getNavigation().getTargetPos();
		return blockPos != null && blockPos.isCenterWithinDistance(this.getPos(), 12.0);
	}

	public void travel(Vec3d movementInput) {
		if (this.isServer() && this.isTouchingWater()) {
			this.updateVelocity(this.getMovementSpeed(), movementInput);
			this.move(MovementType.SELF, this.getVelocity());
			this.setVelocity(this.getVelocity().multiply(0.9));
			if (this.getTarget() == null) {
				this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
			}
		} else {
			super.travel(movementInput);
		}
	}

	@Override
	public boolean canBeLeashedBy(PlayerEntity player) {
		return true;
	}
}
