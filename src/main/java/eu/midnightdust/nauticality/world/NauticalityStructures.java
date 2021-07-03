package eu.midnightdust.nauticality.world;

import eu.midnightdust.nauticality.config.NauticalityConfig;
import eu.midnightdust.nauticality.world.structure.PirateShipStructure;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

public class NauticalityStructures {
    public static final StructureFeature<StructurePoolFeatureConfig> PIRATE_SHIP = new PirateShipStructure();
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ?> CONFIGURED_PIRATE_SHIP = PIRATE_SHIP.configure(new StructurePoolFeatureConfig(() -> PirateShipStructure.PIRATE_SHIP_POOL, 1));

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, new Identifier(MOD_ID, "pirate_ship"), CONFIGURED_PIRATE_SHIP);

        FabricStructureBuilder<StructurePoolFeatureConfig, StructureFeature<StructurePoolFeatureConfig>> pirateShip =
                FabricStructureBuilder.create(new Identifier(MOD_ID,"pirate_ship"), PIRATE_SHIP)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(100 - NauticalityConfig.pirateShipRate, 5, 16)
                .superflatFeature(CONFIGURED_PIRATE_SHIP);
        pirateShip.register();
    }
}
