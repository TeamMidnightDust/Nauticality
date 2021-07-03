package eu.midnightdust.nauticality.world.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.structure.MarginedStructureStart;
import net.minecraft.structure.PoolStructurePiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;

import static eu.midnightdust.nauticality.NauticalityMain.MOD_ID;

public class PirateShipStructure extends StructureFeature<StructurePoolFeatureConfig> {
    public static final Identifier PIRATE_SHIPS = new Identifier(MOD_ID,"pirate_ships");
    public static final StructurePool PIRATE_SHIP_POOL = StructurePools.register(new StructurePool(PIRATE_SHIPS, new Identifier("empty"), ImmutableList.of(
            new Pair<>(StructurePoolElement.ofSingle(MOD_ID + ":pirate_ship"), 1)),
                    StructurePool.Projection.RIGID
            )
    );
    final boolean field_25836;
    final boolean surface;
    private final int structureStartY;

    public PirateShipStructure() {
        this(-2);
    }

    public PirateShipStructure(int structureStartY) {
        this(structureStartY, true, true);
    }

    public PirateShipStructure(int structureStartY, boolean field_25836, boolean surface) {
        super(StructurePoolFeatureConfig.CODEC);
        this.structureStartY = structureStartY;
        this.field_25836 = field_25836;
        this.surface = surface;
    }


    @Override
    public StructureStartFactory<StructurePoolFeatureConfig> getStructureStartFactory() {
        return PirateShipStructure.Start::new;
    }

    @Override
    protected boolean shouldStartAt(ChunkGenerator chunkGenerator, BiomeSource biomeSource, long worldSeed, ChunkRandom random, ChunkPos pos, Biome biome, ChunkPos chunkPos, StructurePoolFeatureConfig config, HeightLimitView world) {
        return true;
    }

    public static class Start extends MarginedStructureStart<StructurePoolFeatureConfig> {
        public Start(StructureFeature<StructurePoolFeatureConfig> s, ChunkPos c, int i, long l) {
            super(s, c, i, l);
        }

        @Override
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos pos, Biome biome, StructurePoolFeatureConfig config, HeightLimitView world) {
            PirateShipStructure structure = (PirateShipStructure) this.getFeature();
            StructurePoolBasedGenerator.method_30419(registryManager, config, PoolStructurePiece::new, chunkGenerator, manager, new BlockPos(pos.x << 4, structure.structureStartY, pos.z << 4), this, this.random, structure.field_25836, structure.surface, world);
            this.setBoundingBoxFromChildren();
        }
    }

}