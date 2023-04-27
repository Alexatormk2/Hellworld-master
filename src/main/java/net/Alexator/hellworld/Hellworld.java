package net.Alexator.hellworld;

import com.mojang.logging.LogUtils;
import net.Alexator.hellworld.block.ModBlocks;
import net.Alexator.hellworld.entity.ModEntityTypes;
import net.Alexator.hellworld.entity.client.DummyRenderer;
import net.Alexator.hellworld.entity.client.LilServantRenderer;
import net.Alexator.hellworld.item.ModItems;
import net.Alexator.hellworld.world.feature.ModConfiguredFeatures;
import net.Alexator.hellworld.world.feature.ModPlacedFeatures;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Hellworld.MOD_ID)
public class Hellworld {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "hellworld";

    private static final Logger LOGGER = LogUtils.getLogger();

    public Hellworld() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        ModEntityTypes.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        GeckoLib.initialize();


    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            EntityRenderers.register(ModEntityTypes.DUMMY.get(), DummyRenderer::new);
                EntityRenderers.register(ModEntityTypes.LILSERVANT_LILY.get(), LilServantRenderer::new);
        }
    }
}
