package net.Alexator.hellworld.item;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.block.ModBlocks;
import net.Alexator.hellworld.entity.ModEntityTypes;
import net.Alexator.hellworld.item.armor.material.HellwordArmorMaterial;
import net.Alexator.hellworld.item.custom.BandageItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Hellworld.MOD_ID);


    //armor
    public static final RegistryObject<ArmorItem> SAKURITA_HELMET = ITEMS.register("sakurita_helmet",
            () -> new ArmorItem(ArmorTiers.SAKURITA, EquipmentSlot.HEAD, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ARMORS)));
    public static final RegistryObject<ArmorItem> SAKURITA_CHESTPLATE = ITEMS.register("sakurita_chestplate",
            () -> new ArmorItem(ArmorTiers.SAKURITA, EquipmentSlot.CHEST, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ARMORS)));

    public static final RegistryObject<ArmorItem> SAKURITA_LEGGINGS = ITEMS.register("sakurita_leggings",
            () -> new ArmorItem(ArmorTiers.SAKURITA, EquipmentSlot.LEGS, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ARMORS)));

    public static final RegistryObject<ArmorItem> SAKURITA_BOOTS = ITEMS.register("sakurita_boots",
            () -> new ArmorItem(ArmorTiers.SAKURITA, EquipmentSlot.FEET, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ARMORS)));

    //tools

    public static final RegistryObject<AxeItem> SAKURITA_AXE = ITEMS.register("sakurita_axe",
            () -> new AxeItem(ToolTiers.SAKURITA, 8, 5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_WEAPONS)));
    public static final RegistryObject<ShovelItem> SAKURITA_SHOVEL = ITEMS.register("sakurita_shovel",
            () -> new ShovelItem(ToolTiers.SAKURITA, 3, 5.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    public static final RegistryObject<HoeItem> SKAURITA_HOE = ITEMS.register("sakurita_hoe",
            () -> new HoeItem(ToolTiers.SAKURITA, 3, 5.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    public static final RegistryObject<PickaxeItem> SAKURITA_PICKAXE = ITEMS.register("sakurita_pickaxe",
            () -> new PickaxeItem(ToolTiers.SAKURITA, 3, 5.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_TOOLS)));
    //weapons
    public static final RegistryObject<SwordItem> SAKURITA_KATANA = ITEMS.register("sakurita_katana",
            () -> new SwordItem(ToolTiers.SAKURITA, 2, 1.5f, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_WEAPONS).stacksTo(1)));
    //items
    public static final RegistryObject<Item> SAKURITA = ITEMS.register("sakurita", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM)));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).build())));
    public static final RegistryObject<Item> BANDAGE = ITEMS.register("bandage", () -> new BandageItem(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).stacksTo(12).durability(2).setNoRepair()));
    public static final RegistryObject<Item> RICE_SEED = ITEMS.register("rice_seed", () -> new ItemNameBlockItem(ModBlocks.RICE_CROP.get(), new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM).stacksTo(64)));
    public static final RegistryObject<Item> ICON = ITEMS.register("icon", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ITEM)));
    //spaw eggs
    public static final RegistryObject<Item> DUMMY_SPAWN_EGG = ITEMS.register("dummy_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DUMMY, 0xf2c12b, 0x000000, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ENTITYS)));

    public static final RegistryObject<Item> LILY_SPAWN_EGG = ITEMS.register("lily_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.LILSERVANT_LILY, 0xbf1111, 0x38761d, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ENTITYS)));

    public static final RegistryObject<Item> NANA_SPAWN_EGG = ITEMS.register("nana_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SERVANT_NANA, 0x000000, 0xef49a0, new Item.Properties().tab(ModCreativeModeTab.HELLWORD_TAB_ENTITYS)));

    public static void register(IEventBus eventBus) {

        ITEMS.register(eventBus);
    }

    public static class ToolTiers {
        public static final Tier SAKURITA = new ForgeTier(
                2,
                2300,
                1.5f,
                3,
                350,
                //  ModBlocks.Tags.NEEDS_EXAMPLE_TOOL
                null,
                () -> Ingredient.of(ModItems.SAKURITA.get()));
    }

    public static class ArmorTiers {
        public static final ArmorMaterial SAKURITA = new HellwordArmorMaterial(
                "sakurita",
                500,
                new int[]{8, 12, 10, 4},
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ModItems.SAKURITA.get()));
    }


}
