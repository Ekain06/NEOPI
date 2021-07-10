package com.ekain06.neopi;

import com.ekain06.neopi.item.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mod implements ModInitializer {
    //public static final int RIDICULOUS_NUMBER = Integer.MAX_VALUE;
    public static final Logger LOGGER = LogManager.getLogger("NEOPI");

    public static final String IDENTIFIER = "neopi";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder
            .create(new Identifier(IDENTIFIER, "item_group"))
            .icon(() -> new ItemStack(AtomItem.ITEM))
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing NEOPI");
        // There must be a better way of doing this
        Registry.register(Registry.ITEM, AtomItem.IDENTIFIER, AtomItem.ITEM);
        Registry.register(Registry.ITEM, AtomicSword.IDENTIFIER, AtomicSword.ITEM);
        Registry.register(Registry.ITEM, AtomicPick.IDENTIFIER, AtomicPick.ITEM);
        Registry.register(Registry.ITEM, AtomicAxe.IDENTIFIER, AtomicAxe.ITEM);
        Registry.register(Registry.ITEM, AtomicShovel.IDENTIFIER, AtomicShovel.ITEM);
        Registry.register(Registry.ITEM, AtomicArmorItems.Helmet.IDENTIFIER, AtomicArmorItems.Helmet.ITEM);
        Registry.register(Registry.ITEM, AtomicArmorItems.Chestplate.IDENTIFIER, AtomicArmorItems.Chestplate.ITEM);
        Registry.register(Registry.ITEM, AtomicArmorItems.Leggings.IDENTIFIER, AtomicArmorItems.Leggings.ITEM);
        Registry.register(Registry.ITEM, AtomicArmorItems.Boots.IDENTIFIER, AtomicArmorItems.Boots.ITEM);
    }
}
