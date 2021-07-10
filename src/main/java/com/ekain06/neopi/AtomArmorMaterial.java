package com.ekain06.neopi;

import com.ekain06.neopi.item.AtomItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import org.jetbrains.annotations.NotNull;

public class AtomArmorMaterial implements ArmorMaterial {
    public static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    public static final int[] PROTECTION_VALUES = new int[] {999, 999, 999, 999};

    @Override
    public int getDurability(@NotNull EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 9999;
    }

    @Override
    public int getProtectionAmount(@NotNull EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 100;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AtomItem.ITEM);
    }

    @Override
    public String getName() {
        return "atomic";
    }

    @Override
    public float getToughness() {
        return 100.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 100.0F;
    }
}
