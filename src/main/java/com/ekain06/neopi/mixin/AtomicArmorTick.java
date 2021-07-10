package com.ekain06.neopi.mixin;

import com.ekain06.neopi.item.AtomicArmorItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class AtomicArmorTick {
    private static void addStatusEffect(AtomicArmorTick aat, StatusEffect se, int amplifier) {
        ((LivingEntityInvoker) aat).callAddStatusEffect(
                new StatusEffectInstance(se, 5, amplifier, false, false, false));
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);
    @Shadow @Final private PlayerAbilities abilities;

    @Inject(at = @At("TAIL"), method = "tick()V")
    private void tick(CallbackInfo ci) {
        // TODO optimize
        ItemStack head = this.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chest = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack legs = this.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack feet = this.getEquippedStack(EquipmentSlot.FEET);

        // DONE is it better if this is an int?  -- most certainly for performance, but adds an extra 24 bytes for each player. Worth it IMHO.
        int armorPieces = 0;

        if (head.isOf(AtomicArmorItems.Helmet.ITEM)) {
            addStatusEffect(this, StatusEffects.WATER_BREATHING, 0);
            addStatusEffect(this, StatusEffects.NIGHT_VISION, 0);
            addStatusEffect(this, StatusEffects.DOLPHINS_GRACE, 0);
            armorPieces++;
        }

        if (chest.isOf(AtomicArmorItems.Chestplate.ITEM)) {
            this.abilities.allowFlying = true;
            armorPieces++;
        } else if (this.abilities.allowFlying) {
            this.abilities.allowFlying = false;
        }

        if (legs.isOf(AtomicArmorItems.Leggings.ITEM)) {
            this.abilities.invulnerable = true;
            armorPieces++;
        } else if (this.abilities.invulnerable) {
            this.abilities.invulnerable = false;
        }

        if (feet.isOf(AtomicArmorItems.Boots.ITEM)) {
            addStatusEffect(this, StatusEffects.SPEED, 5);  // this way we don't need to worry about "unsetting" the speed
            addStatusEffect(this, StatusEffects.JUMP_BOOST, 2);
            armorPieces++;
        }

        if (armorPieces == 4) {  // aka full set's effects
            addStatusEffect(this, StatusEffects.REGENERATION, 999);
            //addStatusEffect(this, StatusEffects.ABSORPTION, 2);
            //addStatusEffect(this, StatusEffects.HEALTH_BOOST, 5);  // useless since user is invulnerable
            addStatusEffect(this, StatusEffects.SATURATION, 999);
        }
    }
}
