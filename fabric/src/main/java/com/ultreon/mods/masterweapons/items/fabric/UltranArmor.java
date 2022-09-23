package com.ultreon.mods.masterweapons.items.fabric;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

public class UltranArmor {
    /**
     * Get the rarity.
     *
     * @param stack the item stack to get the rarity for.
     * @return the rarity.
     */
    @NotNull
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

}
