package net.Alexator.hellworld.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.custom.DummyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DummyRenderer extends GeoEntityRenderer<DummyEntity> {
    public DummyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DummyModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(DummyEntity animatable) {
        return new ResourceLocation(Hellworld.MOD_ID, "textures/entity/dummy.png");
    }

    @Override
    public RenderType getRenderType(DummyEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer,
                                    int packedLight, ResourceLocation texture) {
       poseStack.scale(0.8f,0.8f,0.8f);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
