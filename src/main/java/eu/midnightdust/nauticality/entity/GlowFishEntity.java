package eu.midnightdust.nauticality.entity;

import eu.midnightdust.nauticality.NauticalityMain;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class GlowFishEntity extends FishEntity implements Bucketable {

    public GlowFishEntity(EntityType<? extends FishEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_TROPICAL_FISH_FLOP;
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(NauticalityMain.GLOW_FISH_BUCKET);
    }
}
