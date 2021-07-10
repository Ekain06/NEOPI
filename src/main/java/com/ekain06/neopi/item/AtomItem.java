package com.ekain06.neopi.item;

import com.ekain06.neopi.Mod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

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
