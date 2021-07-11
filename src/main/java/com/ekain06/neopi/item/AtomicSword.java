package com.ekain06.neopi.item;

import com.ekain06.neopi.AtomToolMaterial;
import com.ekain06.neopi.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;


public class AtomicSword extends SwordItem {
    public AtomicSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, @NotNull LivingEntity target, LivingEntity attacker) {
        // Intentionally not removing durability

        var targetType = target.getType();

        // DONE less if else (optimize) -- not worth it since it's only 4 statements
        if (EntityType.ZOMBIE.equals(targetType))
            target.dropItem(Items.ZOMBIE_HEAD);
        else if (EntityType.SKELETON.equals(targetType))
            target.dropItem(Items.SKELETON_SKULL);
        else if (EntityType.WITHER_SKELETON.equals(targetType))
            target.dropItem(Items.WITHER_SKELETON_SKULL);
        else if (EntityType.CREEPER.equals(targetType))
            target.dropItem(Items.CREEPER_HEAD);

        target.kill();  // Following the DE tradition
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, @NotNull BlockState state, BlockPos pos, LivingEntity miner) {
        // Again, skipping durability decrease
        return true;
    }

    public static final AtomicSword ITEM = new AtomicSword(AtomToolMaterial.MATERIAL, 0, -0.1F,
            AtomToolMaterial.DEFAULT_SETTINGS);
    public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_sword");

}
