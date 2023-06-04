package net.Alexator.hellworld.entity.client;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.robots.LilyEntity;
import net.Alexator.hellworld.entity.robots.NanaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LilyModel extends AnimatedGeoModel<LilyEntity> {

    @Override
    public ResourceLocation getModelResource(LilyEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "geo/lily.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LilyEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "textures/entity/lily.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LilyEntity animatable) {
        return new ResourceLocation(Hellworld.MOD_ID, "animations/lily.animation.json");
    }
}
