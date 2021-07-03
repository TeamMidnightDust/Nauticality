package eu.midnightdust.nauticality.mixin;

import eu.midnightdust.nauticality.NauticalityMain;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity {
    @Inject(method = "getPreferredEquipmentSlot", at = @At(value = "TAIL"), cancellable = true)
    private static void getPreferredEquipmentSlot(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> info) {
        Item item = stack.getItem();
        if(item == NauticalityMain.Eyepatch) {
            info.setReturnValue(EquipmentSlot.HEAD);
        }
    }
}
