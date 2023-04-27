package net.Alexator.hellworld.entity.client;

import net.Alexator.hellworld.Hellworld;

import net.Alexator.hellworld.entity.custom.LilServantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

    public class LilServantModel  extends AnimatedGeoModel<LilServantEntity> {



        @Override
        public ResourceLocation getModelResource(LilServantEntity object) {
            return new ResourceLocation(Hellworld.MOD_ID, "geo/lily.geo.json");
        }

        @Override
        public ResourceLocation getTextureResource(LilServantEntity object) {
            return new ResourceLocation(Hellworld.MOD_ID, "textures/entity/lily.png");
        }

        @Override
        public ResourceLocation getAnimationResource(LilServantEntity animatable) {
            return new ResourceLocation(Hellworld.MOD_ID, "animations/lil_servant1.animation.json");
        }
    }
