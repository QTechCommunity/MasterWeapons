package com.ultreon.mods.masterweapons.init.fabric;

import com.jab125.limeappleboat.thonkutil.enumapi.v1.api.ItemRarityCreator;
import com.ultreon.mods.masterweapons.MasterWeapons;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class ModRaritiesImpl {
    public static final Rarity LEGENDARY = ItemRarityCreator.create(MasterWeapons.res("legendary"), ChatFormatting.RED);

    public static Rarity getLegendary() {
        return LEGENDARY;
    }
}
