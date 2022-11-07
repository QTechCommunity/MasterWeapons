package com.ultreon.mods.masterweapons.init.fabric;

import com.jab125.limeappleboat.thonkutil.enumapi.v1.api.creator.RarityCreator;
import com.ultreon.mods.masterweapons.MasterWeapons;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class ModRaritiesImpl {
//    public static final Rarity LEGENDARY = RarityCreator.create(MasterWeapons.res("legendary"), ChatFormatting.RED);
    public static final Rarity LEGENDARY = Rarity.EPIC;

    public static Rarity getLegendary() {
        return LEGENDARY;
    }
}
