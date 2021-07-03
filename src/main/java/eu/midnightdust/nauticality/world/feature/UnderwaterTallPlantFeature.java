package eu.midnightdust.nauticality.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.ProbabilityConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Random;

public class UnderwaterTallPlantFeature extends Feature<ProbabilityConfig> {
    BlockStateProvider blockStateProvider;

    public UnderwaterTallPlantFeature(Codec<ProbabilityConfig> codec, BlockStateProvider blockStateProvider) {
        super(codec);
        this.blockStateProvider = blockStateProvider;
    }

    @Override
    public boolean generate(FeatureContext<ProbabilityConfig> context) {
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        int i = random.nextInt(8) - random.nextInt(8);
        int j = random.nextInt(8) - random.nextInt(8);
        int k = structureWorldAccess.getTopY(Heightmap.Type.OCEAN_FLOOR, blockPos.getX() + i, blockPos.getZ() + j);
        BlockPos blockPos2 = new BlockPos(blockPos.getX() + i, k, blockPos.getZ() + j);

        if (structureWorldAccess.getBlockState(blockPos2).isOf(Blocks.WATER)) {
            BlockState blockState = blockStateProvider.getBlockState(random,blockPos);
            BlockState blockState2 = blockStateProvider.getBlockState(random,blockPos).with(Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER);

            if (blockState.canPlaceAt(structureWorldAccess, blockPos2)) {
                structureWorldAccess.setBlockState(blockPos2, blockState, 2);
                structureWorldAccess.setBlockState(blockPos2.up(), blockState2, 2);
                return true;
            }
        }
        return false;
    }
}
