package eu.midnightdust.nauticality.entity.client.renderer;

import eu.midnightdust.nauticality.entity.SubmarineEntity;
import eu.midnightdust.nauticality.entity.client.model.SubmarineModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3f;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

@Environment(EnvType.CLIENT)
public class SubmarineRenderer extends EntityRenderer<SubmarineEntity> implements FeatureRendererContext<SubmarineEntity, SubmarineModel> {
    public static final EntityModelLayer SUBMARINE_MODEL_LAYER = new EntityModelLayer(new Identifier("nauticality","entity"), "submarine");
    private static EmissiveOverlayRenderer overlay;
    private final SubmarineModel model;


    public SubmarineRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        model = new SubmarineModel(ctx.getPart(SUBMARINE_MODEL_LAYER));
        overlay = new EmissiveOverlayRenderer(this, new Identifier(MOD_ID,"textures/entity/submarine/submarine_emissive_layer.png"));
    }
    public void render(SubmarineEntity entity, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrixStack, vertexConsumers, light);
        float pitch = entity.getPitch();
        Entity passenger = entity.getFirstPassenger();
        if (passenger != null) pitch = passenger.getPitch() * 0.5F;
        matrixStack.push();
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180F - yaw));
        matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(180F));
        //matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion((yaw - entity.prevRoll)*8));
        entity.prevRoll = yaw;
        matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180.0F + pitch));
        matrixStack.translate(0.0D , -1.75D, -0.5D + (90 + entity.getPitch()) * 0.01f);
        matrixStack.scale(1.2f,1.2f,1.2f);
        model.setAngles(entity,tickDelta,0,0,yaw,entity.getPitch());
        model.render(matrixStack, vertexConsumers.getBuffer(RenderLayer.getEntityCutout(getTexture(entity))), light, OverlayTexture.DEFAULT_UV,1f,1f,1f,1f);
        overlay.render(matrixStack,vertexConsumers,light,entity,yaw,0f,tickDelta,0f,yaw,entity.getPitch());
        matrixStack.pop();
    }

    @Override
    public SubmarineModel getModel() {
        return model;
    }

    @Override
    public Identifier getTexture(SubmarineEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/submarine/submarine.png");
    }
}
