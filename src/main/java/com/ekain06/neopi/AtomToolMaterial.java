package com.ekain06.neopi;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AtomToolMaterial implements ToolMaterial {
    public static final AtomToolMaterial MATERIAL = new AtomToolMaterial();

    @Override
    public int getDurability() {
        return 9999;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9999;
    }

    @Override
    public float getAttackDamage() {
        return 0F;
    }

    @Override
    public int getMiningLevel() {
        return 20;
    }

    @Override
    public int getEnchantability() {
        return 9999;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(AtomItem.ITEM);
    }
}
