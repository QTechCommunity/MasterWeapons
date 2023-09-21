package com.ultreon.mods.masterweapons.init.forge;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

/**
 * Rarity initialization class.
 *
 * @author XyperCode
 * @since 3.0.0
 */
public class ModRaritiesImpl {
    /**
     * Legendary rarity.
     */
    public static final Rarity LEGENDARY = Rarity.create("LEGENDARY", ChatFormatting.RED);

    public static Rarity getLegendary() {
        return LEGENDARY;
    }
}
