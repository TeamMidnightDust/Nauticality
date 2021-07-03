package eu.midnightdust.nauticality.entity.client.renderer;

import eu.midnightdust.nauticality.entity.PirateEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.IllagerEntityModel;
import net.minecraft.util.Identifier;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

@Environment(EnvType.CLIENT)
public class PirateRenderer extends IllagerEntityRenderer<PirateEntity> {
    private static final Identifier TEXTURE = new Identifier(MOD_ID,"textures/entity/illager/pirate.png");

    public PirateRenderer(EntityRendererFactory.Context context) {
        super(context, new IllagerEntityModel<>(context.getPart(EntityModelLayers.PILLAGER)), 0.5F);
        this.addFeature(new HeldItemFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(PirateEntity pillagerEntity) {
        return TEXTURE;
    }
}
