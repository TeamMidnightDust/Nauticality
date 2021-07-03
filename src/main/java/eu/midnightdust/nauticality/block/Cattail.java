package eu.midnightdust.nauticality.block;

import eu.midnightdust.nauticality.NauticalityMain;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class Cattail extends TallPlantBlock {
    public Cattail(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(NauticalityMain.Cattail);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER) {
            return Fluids.WATER.getStill(false);
        }
        return Fluids.EMPTY.getDefaultState();
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            BlockState lowerBlockState = world.getBlockState(pos.down());
            return lowerBlockState.isOf(this) && lowerBlockState.get(HALF) == DoubleBlockHalf.LOWER && world.getFluidState(pos).isEmpty();
        } else {
            FluidState fluidState = world.getFluidState(pos);
            FluidState upperFluidState = world.getFluidState(pos.up());
            return fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8 && upperFluidState.isEmpty();
        }
    }
    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = super.getPlacementState(ctx);
        if (blockState != null) {
            FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
            if (fluidState.isIn(FluidTags.WATER) && fluidState.getLevel() == 8) {
                return blockState;
            }
        }

        return blockState;
    }
}
