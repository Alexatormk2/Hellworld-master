package net.Alexator.hellworld.entity.client;

import net.Alexator.hellworld.Hellworld;
import net.Alexator.hellworld.entity.custom.LilServantEntity;
import net.Alexator.hellworld.entity.custom.NanaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NanaModel extends AnimatedGeoModel<NanaEntity> {







    @Override
    public ResourceLocation getModelResource(NanaEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "geo/nana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NanaEntity object) {
        return new ResourceLocation(Hellworld.MOD_ID, "textures/entity/nana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NanaEntity animatable) {
        return new ResourceLocation(Hellworld.MOD_ID, "animations/servant_nana.animation.json");
    }
}
