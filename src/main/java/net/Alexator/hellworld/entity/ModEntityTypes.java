package net.Alexator.hellworld.entity;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.custom.DummyEntity;
import net.Alexator.hellworld.entity.custom.LilServantEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hellworld.MOD_ID);

    public static final RegistryObject<EntityType<DummyEntity>> DUMMY =
            ENTITY_TYPES.register("dummy",
                    ()-> EntityType.Builder.of(DummyEntity::new, MobCategory.MONSTER).sized(0.4f,0.9f).build(new ResourceLocation(Hellworld.MOD_ID,"dummy").toString()));


    public static final RegistryObject<EntityType<LilServantEntity>> LILSERVANT_LILY =
            ENTITY_TYPES.register("lily",
                    ()-> EntityType.Builder.of(LilServantEntity::new, MobCategory.CREATURE).sized(0.4f,1.6f).build(new ResourceLocation(Hellworld.MOD_ID,"lily").toString()));


    public static void register(IEventBus eventBus){
ENTITY_TYPES.register(eventBus);

}





}