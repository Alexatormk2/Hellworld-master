package net.Alexator.hellworld.entity;

import net.Alexator.hellworld.entity.custom.LilservantEntity;
import net.Alexator.hellworld.Hellworld;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {


    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hellworld.MOD_ID);

   // public static final RegistryObject<EntityType<LilservantEntity>> LILSERVANT = ENTITIES.register("lilservant",() -> EntityType.Builder.of(LilservantEntity::new, MobCategory.CREATURE).build(Hellworld.MOD_ID + ":Lily"));




}
