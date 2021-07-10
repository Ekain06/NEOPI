package com.ekain06.neopi;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class AtomItem extends Item {
    public AtomItem(Settings settings) {
        super(settings);
    }

    public static final AtomItem ITEM = new AtomItem(new FabricItemSettings()
            //.maxCount(256)  // Cool gimmick I guess?  // Doesn't work like expected.
            .rarity(Rarity.RARE)
            .group(Mod.ITEM_GROUP)
    );
    public static final Identifier IDENTIFIER = new Identifier(Mod.IDENTIFIER, "atom");
}
