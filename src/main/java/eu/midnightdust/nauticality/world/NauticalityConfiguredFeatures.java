package eu.midnightdust.nauticality.world;

import eu.midnightdust.nauticality.NauticalityMain;
import eu.midnightdust.nauticality.config.NauticalityConfig;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.HeightmapDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placer.SimpleBlockPlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

public class NauticalityConfiguredFeatures {
    public static ConfiguredDecorator<?> SQUARE_HEIGHTMAP_SPREAD_DOUBLE = Decorator.HEIGHTMAP_SPREAD_DOUBLE.configure(new HeightmapDecoratorConfig(Heightmap.Type.MOTION_BLOCKING)).spreadHorizontally();
    public static ConfiguredFeature<?, ?> ALGAE_SWAMP = Feature.RANDOM_PATCH.configure(
            new RandomPatchFeatureConfig.Builder(new SimpleBlockStateProvider(NauticalityMain.Algae.getDefaultState()), SimpleBlockPlacer.INSTANCE).tries(10).build())
            .decorate(SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(NauticalityConfig.algaeRate - 1);

    public static ConfiguredFeature<?, ?> ALGAE_UNDERWATER = NauticalityFeatures.UNDERWATER_ALGAE_FEATURE.configure(new ProbabilityConfig(1)).repeat(NauticalityConfig.underwaterAlgaeRate - 1);
    public static ConfiguredFeature<?, ?> CATTAIL_SWAMP = NauticalityFeatures.UNDERWATER_CATTAIL_FEATURE.configure(new ProbabilityConfig(1)).repeat(NauticalityConfig.cattailRate - 1);

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "algae_swamp"), ALGAE_SWAMP);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "algae_underwater"), ALGAE_UNDERWATER);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "cattail_swamp"), CATTAIL_SWAMP);
    }
}
