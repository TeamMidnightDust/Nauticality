package eu.midnightdust.nauticality.world;

import eu.midnightdust.nauticality.NauticalityMain;
import eu.midnightdust.nauticality.world.feature.UnderwaterFeature;
import eu.midnightdust.nauticality.world.feature.UnderwaterTallPlantFeature;
import net.minecraft.state.property.Properties;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;

public class NauticalityFeatures {
    public static SimpleBlockStateProvider Algae = new SimpleBlockStateProvider(NauticalityMain.Algae.getDefaultState().with(Properties.WATERLOGGED, true));
    public static SimpleBlockStateProvider Cattail = new SimpleBlockStateProvider(NauticalityMain.Cattail.getDefaultState());
    public static final UnderwaterFeature UNDERWATER_ALGAE_FEATURE = Registry.register(Registry.FEATURE, "underwater_algae", new UnderwaterFeature(ProbabilityConfig.CODEC, Algae));
    public static final UnderwaterTallPlantFeature UNDERWATER_CATTAIL_FEATURE = Registry.register(Registry.FEATURE, "swamp_cattail", new UnderwaterTallPlantFeature(ProbabilityConfig.CODEC, Cattail));
}
