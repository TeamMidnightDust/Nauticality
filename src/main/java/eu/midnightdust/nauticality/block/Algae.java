package eu.midnightdust.nauticality.block;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Algae extends PlantBlock implements Waterloggable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, -0.2D, 0.0D, 16.0D, 0.3D, 16.0D);
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public Algae(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED,false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity.isTouchingWater() && !(entity instanceof BoatEntity) && entity.getY() <= pos.getY() + 0.1f) {
            entity.slowMovement(state, new Vec3d(2, 2, 2));
        }
        if (world instanceof ServerWorld && entity instanceof BoatEntity) {
            world.breakBlock(new BlockPos(pos), false, entity);
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        FluidState fluidState = world.getFluidState(pos);
        FluidState fluidState2 = world.getFluidState(pos.up());
        return fluidState.getFluid() == Fluids.WATER || fluidState2.getFluid() == Fluids.WATER;
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
}
