package net.Alexator.hellworld.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    public static final CreativeModeTab HELLWORD_TAB_ITEM = new CreativeModeTab("hellworld_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ICON.get());
        }
    };
    public static final CreativeModeTab HELLWORD_TAB_BLOCK = new CreativeModeTab("hellworld_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ICON.get());
        }
    };

    public static final CreativeModeTab HELLWORD_TAB_TOOLS = new CreativeModeTab("hellworld_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SAKURITA_PICKAXE.get());
        }
    };
    public static final CreativeModeTab HELLWORD_TAB_WEAPONS = new CreativeModeTab("hellworld_weapons") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SAKURITA_KATANA.get());
        }
    };
}
