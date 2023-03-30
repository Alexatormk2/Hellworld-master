package net.Alexator.hellworld.item;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.block.ModBlocks;
import net.Alexator.hellworld.item.custom.BandageItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Hellworld.MOD_ID);
    //tools
    public static final RegistryObject<ShovelItem> SAKURITA_SHOVEL = ITEMS.register("sakurita_shovel",
            ()-> new ShovelItem(null,3,2.5f,new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    public static  final  RegistryObject<HoeItem> SKAURITA_HOE =ITEMS.register("sakurita_hoe",
            () -> new HoeItem(null,3,2.5f,new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    public static final RegistryObject<PickaxeItem> SAKURITA_PICKAXE = ITEMS.register("sakurita_pickaxe",
            () -> new PickaxeItem(null, 3, 2.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    //weapons
    public static final RegistryObject<SwordItem> SAKURITA_KATANA = ITEMS.register("sakurita_katana",
            () -> new SwordItem(null, 5, 1.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_WEAPONS).stacksTo(1)));
    //items
    public static final RegistryObject<Item> SAKURITA = ITEMS.register("sakurita", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM)));
    public static final RegistryObject<Item> Rice = ITEMS.register("rice", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).build())));
    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage", () -> new BandageItem(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).stacksTo(12).durability(3).setNoRepair()));
    public static final RegistryObject<Item> RICE_SEED = ITEMS.register("rice_seed", () -> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).stacksTo(64)));
    public static final RegistryObject<Item> ICON = ITEMS.register("icon", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }
}
