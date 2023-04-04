package net.Alexator.hellworld.block;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.block.custom.HealingBlock;
import net.Alexator.hellworld.block.custom.ModFlammableRotatedPillarBlock;
import net.Alexator.hellworld.block.custom.RiceCropBlock;
import net.Alexator.hellworld.block.custom.SakuritaLampBlock;
import net.Alexator.hellworld.item.ModCreativeModeTab;
import net.Alexator.hellworld.item.ModItems;
import net.Alexator.hellworld.world.feature.SakuraTreeGrower;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Hellworld.MOD_ID);

    //sakurita ores



    public static final RegistryObject<Block> SAKURITA_ORE = registerBlock("sakurita_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    public static final RegistryObject<Block> NEHTER_SAKURITA_ORE = registerBlock("nether_sakurita_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    public static final RegistryObject<Block> END_SAKURITA_ORE = registerBlock("end_sakurita_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    public static final RegistryObject<Block> DEEPSLATE_SAKURITA_ORE = registerBlock("deepslate_sakurita_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    //especiales
    public static final RegistryObject<Block> HEALING_BLOCK = registerBlock("healing_block",
            () -> new HealingBlock(BlockBehaviour.Properties.of(Material.AMETHYST).sound(SoundType.AMETHYST).strength(3f)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    public static final RegistryObject<Block> SAKURITA_LAMP = registerBlock("sakurita_lamp",
            () -> new SakuritaLampBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).lightLevel(state -> state.getValue(SakuritaLampBlock.LIT) ? 15 : 0)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    public static final RegistryObject<Block> SAKURIRTA_BLOCK = registerBlock("sakurita_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).strength(3f).sound(SoundType.METAL)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    //arboles
    //1-sakura
    public static final RegistryObject<Block> SAKURA_LOG = registerBlock("sakura_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).requiresCorrectToolForDrops()), ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> SAKURA_WOOD = registerBlock("sakura_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops()), ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> STRIPPED_SAKURA_LOG = registerBlock("stripped_sakura_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).requiresCorrectToolForDrops()), ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> STRIPPED_SAKURA_WOOD = registerBlock("stripped_sakura_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).requiresCorrectToolForDrops()), ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> SAKURA_PLANKS = registerBlock("sakura_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }


                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
            }, ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> SAKURA_LEAVES = registerBlock("sakura_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).requiresCorrectToolForDrops()){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }, ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    public static final RegistryObject<Block> SAKURA_SAPPLING = registerBlock("sakura_sappling",
            () -> new SaplingBlock(new SakuraTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.HELLWORD_TAB_BLOCK);

    //flores
    public static final RegistryObject<Block> SAKURA_FLOWER = registerBlock("sakura_flower",
            () -> new Block(BlockBehaviour.Properties.of(Material.PLANT).strength(1f).sound(SoundType.GRASS).noOcclusion()), ModCreativeModeTab.HELLWORD_TAB_BLOCK);
    //crops

    public static final RegistryObject<Block> RICE_CROP = BLOCKS.register("rice_crop",
            () -> new RiceCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
