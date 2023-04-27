package net.Alexator.hellworld.entity.client;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.custom.DummyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DummyModel extends AnimatedGeoModel<DummyEntity> {
    @Override
    public ResourceLocation getModelResource(DummyEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "geo/dummy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DummyEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "textures/entity/dummy.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DummyEntity animatable) {
        return new ResourceLocation(Hellworld.MOD_ID, "animations/dummy_mele.animation.json");
    }
}
