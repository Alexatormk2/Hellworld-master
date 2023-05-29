package net.Alexator.hellworld.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.Alexator.hellworld.entity.robots.NanaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NanaRenderer extends GeoEntityRenderer<NanaEntity> {


    public NanaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NanaModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public RenderType getRenderType(NanaEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer,
                                    int packedLight, ResourceLocation texture) {

        poseStack.scale(2f,2f,2f);
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
