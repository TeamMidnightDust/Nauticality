package eu.midnightdust.nauticality;

import eu.midnightdust.nauticality.entity.client.model.SubmarineModel;
import eu.midnightdust.nauticality.entity.client.renderer.GlowFishRenderer;
import eu.midnightdust.nauticality.entity.client.renderer.PirateRenderer;
import eu.midnightdust.nauticality.entity.client.renderer.SubmarineRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.fabric.impl.client.rendering.ColorProviderRegistryImpl;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@SuppressWarnings({"deprecation","UnstableApiUsage"})
public class NauticalityClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(NauticalityMain.GLOW_FISH, GlowFishRenderer::new);
        EntityRendererRegistry.INSTANCE.register(NauticalityMain.PIRATE, PirateRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(SubmarineRenderer.SUBMARINE_MODEL_LAYER, SubmarineModel::getTexturedModelData);
        EntityRendererRegistry.INSTANCE.register(NauticalityMain.SUBMARINE, SubmarineRenderer::new);
        BlockRenderLayerMapImpl.INSTANCE.putBlock(NauticalityMain.Algae, RenderLayer.getCutout());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(NauticalityMain.Cattail, RenderLayer.getCutout());
        ColorProviderRegistryImpl.BLOCK.register((state, world, pos, tintIndex) -> world == null ? 0 : world.getColor(pos, BiomeColors.FOLIAGE_COLOR), NauticalityMain.Algae);
        ColorProviderRegistryImpl.ITEM.register((stack, tintIndex) -> 6975545, NauticalityMain.Algae);
        FabricModelPredicateProviderRegistry.register(NauticalityMain.Eyepatch.asItem(), new Identifier("right"), (stack, world, entity, seed) -> (stack.getTag() != null && stack.getTag().getBoolean("right")) ?  1 : 0);
    }
}
