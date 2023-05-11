package net.Alexator.hellworld.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.function.Predicate;

public class NanaEntity extends Animal implements IAnimatable {
   public  NanaEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }
    public static final Predicate<LivingEntity> PREY_SELECTOR = (type) -> {
        EntityType<?> entitytype = type.getType();
        return entitytype == EntityType.SPIDER || entitytype == EntityType.SKELETON ;
    };

    private AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.servant_nana.walk", ILoopType.EDefaultLoopTypes.LOOP));
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.servant_nana.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.BLAZE_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.BLAZE_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WARDEN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
     //   this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0D, true));
      //  this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
     //   this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
      //  this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
      //  this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());

      //  this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>(this, Animal.class, false, PREY_SELECTOR));

        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, AbstractSkeleton.class, false));

    }
    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.ATTACK_SPEED, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f).build();
    }
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
        data.addAnimationController(new AnimationController(this, "attackController",
                0, this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationEvent event) {


        if(this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.servant_nana.attacking",ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
     //   event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.servant_nana.attack", false));

    }

    @Override
    public AnimationFactory getFactory() {
        {
            return this.animationFactory;
        }
    }}
