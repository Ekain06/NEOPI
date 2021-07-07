package com.ekain06.neopi;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class AtomicAxe extends AxeItem {
    public AtomicAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, @NotNull LivingEntity target, LivingEntity attacker) {
        // Purposely skips durability decrease
        target.kill();
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        // Same as above
        return true;
    }

    public static final AtomicAxe ITEM = new AtomicAxe(AtomToolMaterial.MATERIAL, 0, -3.2F,
            new FabricItemSettings().group(Mod.ITEM_GROUP).rarity(Rarity.RARE));
    public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_axe");
}
