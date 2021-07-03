package eu.midnightdust.nauticality.entity;

import eu.midnightdust.nauticality.NauticalityMain;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PillagerEntity;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class PirateEntity extends PillagerEntity {

    public PirateEntity(EntityType<? extends PillagerEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        this.goalSelector.add(4, new AttackGoal(this));
    }

    @Override
    protected void initEquipment(LocalDifficulty difficulty) {
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.equipStack(EquipmentSlot.OFFHAND, new ItemStack(Items.SPYGLASS));
        ItemStack eyepatch = new ItemStack(NauticalityMain.Eyepatch);
        if (new Random().nextBoolean()) {
            eyepatch.getOrCreateTag().putBoolean("right", true);
        }
        this.equipStack(EquipmentSlot.HEAD, eyepatch);
    }
    @Override
    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        this.getAttributeInstance(EntityAttributes.GENERIC_FOLLOW_RANGE).addPersistentModifier(new EntityAttributeModifier("Random spawn bonus", this.random.nextGaussian() * 0.05D, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        this.setLeftHanded(this.random.nextFloat() < 0.05F);
        this.initEquipment(difficulty);
        return entityData;
    }

    static class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(PirateEntity pirate) {
            super(pirate, 1.0D, false);
        }

        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            if (this.mob.getVehicle() instanceof RavagerEntity) {
                float f = this.mob.getVehicle().getWidth() - 0.1F;
                return f * 2.0F * f * 2.0F + entity.getWidth();
            } else {
                return super.getSquaredMaxAttackDistance(entity);
            }
        }
    }
}
