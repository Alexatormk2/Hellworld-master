package net.Alexator.hellworld.world.feature;

import com.google.common.base.Suppliers;
import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Hellworld.MOD_ID);


    //preparacion dels spaw de los ores, los cuales reemplzaran stone,netherrack y end stone
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAKURITA_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAKURITA_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAKURITA_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_SAKURITA_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_SAKURITA_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_SAKURITA_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NEHTER_SAKURITA_ORE.get().defaultBlockState())));
    //config spaw
    public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURITA_ORE = CONFIGURED_FEATURES.register("sakurita_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SAKURITA_ORES.get(), 7)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_SAKURITA_ORE = CONFIGURED_FEATURES.register("nether_sakurita_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_SAKURITA_ORES.get(), 8)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> END_SAKURITA_ORE = CONFIGURED_FEATURES.register("end_sakurita_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_SAKURITA_ORES.get(), 9)));

    public static  final  RegistryObject<ConfiguredFeature<?,?>> SAKURA =
            CONFIGURED_FEATURES.register("sakurae", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.SAKURA_LOG.get()),
                            new StraightTrunkPlacer(5, 6, 3),
                            BlockStateProvider.simple(ModBlocks.SAKURA_LEAVES.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static final RegistryObject<ConfiguredFeature<?, ?>> SAKURA_SPAWN =
            CONFIGURED_FEATURES.register("red_maple_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.SAKURA_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.SAKURA_CHECKED.getHolder().get())));

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
