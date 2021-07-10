package com.ekain06.neopi.item;

import com.ekain06.neopi.AtomArmorMaterial;
import com.ekain06.neopi.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class AtomicArmorItems {
    protected static final ArmorMaterial MATERIAL = new AtomArmorMaterial();
    protected static final FabricItemSettings ITEM_SETTINGS = new FabricItemSettings()
            .group(Mod.ITEM_GROUP)
            .rarity(Rarity.RARE);

    // TODO there's probably a smarter way of doing this.
    public static class Helmet {
        public static final ArmorItem ITEM = new UnbreakableArmorItem(MATERIAL, EquipmentSlot.HEAD, ITEM_SETTINGS);
        public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_helmet");
    }
    public static class Chestplate {
        public static final ArmorItem ITEM = new UnbreakableArmorItem(MATERIAL, EquipmentSlot.CHEST, ITEM_SETTINGS);
        public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_chestplate");
    }
    public static class Leggings {
        public static final ArmorItem ITEM = new UnbreakableArmorItem(MATERIAL, EquipmentSlot.LEGS, ITEM_SETTINGS);
        public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_pants");
    }
    public static class Boots {
        public static final ArmorItem ITEM = new UnbreakableArmorItem(MATERIAL, EquipmentSlot.FEET, ITEM_SETTINGS);
        public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atomic_boots");
    }
}
