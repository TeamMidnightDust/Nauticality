package eu.midnightdust.nauticality.entity;

import eu.midnightdust.nauticality.NauticalityMain;
import eu.midnightdust.nauticality.mixin.BoatEntityAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SubmarineEntity extends BoatEntity {
    public boolean pressingForward;
    public float prevRoll = 0;
    public float rotorAngle;

    public SubmarineEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
        this.stepHeight = 1.0F;
    }
    @Override
    public Item asItem() {
        return NauticalityMain.SubmarineItem;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }
    @Override
    public void tick() {
        super.tick();
        ((BoatEntityAccessor)this).setTicksUnderwater(0);
        updateVelocity();
        this.move(MovementType.SELF, this.getVelocity());
        if (this.getFirstPassenger() != null && this.pressingForward) {
            Entity passenger = this.getFirstPassenger();
            this.setPitch(passenger.getPitch() * 0.5F);
        }
    }
    @Override
    public boolean hasNoGravity() {
        return true;
    }
    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
    }
    @Override
    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < 2;
    }
    @Override
    public void updatePassengerPosition(Entity passenger) {
        super.updatePassengerPosition(passenger);
        if (this.hasPassenger(passenger)) {
            if (passenger instanceof LivingEntity livingEntity) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,2,1,true,false,false));
            }
        }
    }
    public void setInputs(boolean pressingLeft, boolean pressingRight, boolean pressingForward, boolean pressingBack) {
        super.setInputs(pressingLeft,pressingRight,pressingForward,pressingBack);
        this.pressingForward = pressingForward;
    }
    private void updateVelocity() {
        Vec3d vec3d = this.getVelocity();
        if (((BoatEntityAccessor)this).getLocation() == BoatEntity.Location.UNDER_WATER && this.getFirstPassenger() != null && this.pressingForward)
            this.setVelocity(vec3d.x * 1.5, vec3d.y - (this.getPitch()) * 0.001, vec3d.z * 1.5);
        Vec3d velocity = this.getVelocity();
        if (touchingWater) this.setVelocity(velocity.x, velocity.y, velocity.z);
        else this.setVelocity(velocity.x * 0.4, -0.75, velocity.z * 0.4);
    }
    public boolean isSubmergedInWater() {
        return false;
    }
}
