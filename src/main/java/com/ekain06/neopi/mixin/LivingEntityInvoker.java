package com.ekain06.neopi.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@SuppressWarnings("UnusedReturnValue")
@Mixin(LivingEntity.class)
public interface LivingEntityInvoker {
    @Invoker("addStatusEffect") boolean callAddStatusEffect(StatusEffectInstance effect);
    @Invoker("setMovementSpeed") void callSetMovementSpeed(float movementSpeed);
    //@Invoker("setHealth") void callSetHealth(float health);
}
