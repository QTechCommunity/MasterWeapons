package com.ultreon.mods.masterweapons.init.fabric;

import net.minecraft.world.item.Rarity;

public class ModRaritiesImpl {
//    public static final Rarity LEGENDARY = RarityCreator.create(MasterWeapons.res("legendary"), ChatFormatting.RED);
    public static final Rarity LEGENDARY = Rarity.EPIC;

    public static Rarity getLegendary() {
        return LEGENDARY;
    }
}
