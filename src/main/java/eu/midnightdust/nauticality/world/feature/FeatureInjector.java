package eu.midnightdust.nauticality.world.feature;

import com.google.common.collect.Lists;
import eu.midnightdust.nauticality.config.NauticalityConfig;
import eu.midnightdust.nauticality.mixin.GenerationSettingsAccessorMixin;
import eu.midnightdust.nauticality.world.NauticalityConfiguredFeatures;
import eu.midnightdust.nauticality.world.NauticalityStructures;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FeatureInjector {

    public static void init() {
        BuiltinRegistries.BIOME.forEach(FeatureInjector::addFeatureToBiome);
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> addFeatureToBiome(biome));
    }

    private static void addFeatureToBiome(Biome biome) {
        if (biome.getCategory() == Biome.Category.SWAMP) {
            if (NauticalityConfig.algaeRate != 0) addFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, NauticalityConfiguredFeatures.ALGAE_SWAMP);
            if (NauticalityConfig.cattailRate != 0) addFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, NauticalityConfiguredFeatures.CATTAIL_SWAMP);
        }
        if (biome.getCategory() == Biome.Category.OCEAN && biome.toString().contains("cold")) {
            if (NauticalityConfig.underwaterAlgaeRate != 0) addFeature(biome, GenerationStep.Feature.VEGETAL_DECORATION, NauticalityConfiguredFeatures.ALGAE_UNDERWATER);
        }
        if (biome.getCategory() == Biome.Category.OCEAN && biome.toString().contains("warm")) {
            if (NauticalityConfig.pirateShipRate != 0) addStructureFeature(biome, NauticalityStructures.CONFIGURED_PIRATE_SHIP);
        }
    }
    public static void addFeature(Biome biome, GenerationStep.Feature step, ConfiguredFeature<?, ?> feature) {
        GenerationSettingsAccessorMixin generationSettingsAccessor  = (GenerationSettingsAccessorMixin) biome.getGenerationSettings();
        int stepIndex = step.ordinal();
        List<List<Supplier<ConfiguredFeature<?, ?>>>> featuresByStep = new ArrayList<>(generationSettingsAccessor.getFeatures());
        while (featuresByStep.size() <= stepIndex) {
            featuresByStep.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(featuresByStep.get(stepIndex));
        features.add(() -> feature);
        featuresByStep.set(stepIndex, features);
        generationSettingsAccessor.setFeatures(featuresByStep);
    }
    public static void addStructureFeature(Biome biome, ConfiguredStructureFeature<?, ?> feature) {
        GenerationSettingsAccessorMixin generationSettingsAccessor  = (GenerationSettingsAccessorMixin) biome.getGenerationSettings();
        List<Supplier<ConfiguredStructureFeature<?, ?>>> features = new ArrayList<>(generationSettingsAccessor.getStructureFeatures());
        features.add(() -> feature);
        generationSettingsAccessor.setStructureFeatures(features);
    }
}