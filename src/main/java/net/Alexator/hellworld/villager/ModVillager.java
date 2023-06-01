package net.Alexator.hellworld.villager;
import com.google.common.collect.ImmutableSet;
import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillager {

    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Hellworld.MOD_ID);


    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Hellworld.MOD_ID);

    public static final RegistryObject<PoiType> BLACKMARKET_BLOCK_POI = POI_TYPES.register("blackmarket_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLACKMARKET_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> BLACKMARKET_CULTIST = VILLAGER_PROFESIONS.register("blackmarket_cultist",
            () -> new VillagerProfession("blackmarket_cultist", x -> x.get() == BLACKMARKET_BLOCK_POI.get(),
                    x -> x.get() == BLACKMARKET_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));
    public  static  void registerPOIs(){

        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockstates").invoke(null,BLACKMARKET_BLOCK_POI.get());
        }catch(InvocationTargetException | IllegalAccessException exception){

        }
    }
    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESIONS.register(eventBus);
    }
}
