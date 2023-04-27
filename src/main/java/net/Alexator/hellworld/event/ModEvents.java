package net.Alexator.hellworld.event;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.ModEntityTypes;
import net.Alexator.hellworld.entity.custom.DummyEntity;
import net.Alexator.hellworld.entity.custom.LilServantEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Hellworld.MOD_ID)
    public static class forgeEvents{


    }
    @Mod.EventBusSubscriber(modid = Hellworld.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvent{
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.DUMMY.get(), DummyEntity.setAttributes());
            event.put(ModEntityTypes.LILSERVANT_LILY.get(), LilServantEntity.setAttributes());
    }

}}
