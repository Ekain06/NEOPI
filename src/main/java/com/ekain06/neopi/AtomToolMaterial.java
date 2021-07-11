package com.ekain06.neopi;

import com.ekain06.neopi.item.AtomItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;

public class AtomToolMaterial implements ToolMaterial {
    public static final AtomToolMaterial MATERIAL = new AtomToolMaterial();
    public static final FabricItemSettings DEFAULT_SETTINGS = new FabricItemSettings().group(Mod.ITEM_GROUP).rarity(Rarity.RARE);

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
