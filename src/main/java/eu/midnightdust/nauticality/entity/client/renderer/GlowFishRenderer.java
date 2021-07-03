package eu.midnightdust.nauticality.entity.client.renderer;

import eu.midnightdust.nauticality.entity.GlowFishEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.CodEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

@Environment(EnvType.CLIENT)
public class GlowFishRenderer extends MobEntityRenderer<GlowFishEntity, CodEntityModel<GlowFishEntity>> {

    public GlowFishRenderer(EntityRendererFactory.Context context) {
        super(context, new CodEntityModel<>(context.getPart(EntityModelLayers.COD)), 0.5F);
        this.addFeature(new EmissiveOverlayRenderer(this, new Identifier(MOD_ID,"textures/entity/glow_fish/glow_fish_emissive_layer.png")));
    }

    @Override
    public Identifier getTexture(GlowFishEntity entity) {
        return new Identifier("nauticality","textures/entity/glow_fish/glow_fish.png");
    }
}
