package com.ekain06.neopi.item;

import com.ekain06.neopi.AtomToolMaterial;
import com.ekain06.neopi.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AtomicHoe extends HoeItem {
    public AtomicHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Purposely skips durability decrease
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        // Same as above
        return true;
    }

    public static final AtomicHoe ITEM = new AtomicHoe(AtomToolMaterial.MATERIAL, 7, -3.2F,
            AtomToolMaterial.DEFAULT_SETTINGS);
    public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_pick");
}
