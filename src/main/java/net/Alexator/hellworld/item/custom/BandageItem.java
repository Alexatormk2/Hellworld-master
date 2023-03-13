package net.Alexator.hellworld.item.custom;

import net.minecraft.advancements.critereon.ItemDurabilityTrigger;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;

import java.util.Objects;


public class BandageItem extends Item {


    public BandageItem(Properties properties) {
        super(properties);

    }



    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        healingPlayer(player);

        return super.use(level, player, interactionHand);
    }

    @Override
    public InteractionResult useOn(UseOnContext pcContext) {
        pcContext.getItemInHand().hurtAndBreak(1, Objects.requireNonNull(pcContext.getPlayer()), (player -> player.broadcastBreakEvent(player.getUsedItemHand())));
        return super.useOn(pcContext);
    }

    private void healingPlayer(Player player) {
        player.addEffect(new MobEffectInstance(new MobEffectInstance(MobEffects.HEAL, 200)));
    }
}
