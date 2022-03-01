package com.ultreon.mods.masterweapons.items;

import com.ultreon.mods.masterweapons.init.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Master item tier.
 *
 * @author Qboi123
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MasterItemTier implements Tier {
    private static final MasterItemTier instance = new MasterItemTier();

    /**
     * Get the instance.
     *
     * @return the instance.
     */
    public static MasterItemTier getInstance() {
        return instance;
    }

    private MasterItemTier() {
    }

    /**
     * Get the maximum amount of uses.
     *
     * @return the maximum amount of uses, always positive infinity.
     */
    @Override
    public int getUses() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the breaking speed / efficiency.
     *
     * @return the block destroy speed, always positive infinity.
     */
    @Override
    public float getSpeed() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the attack damage.
     *
     * @return the attack damage, always positive infinity.
     */
    @Override
    public float getAttackDamageBonus() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the harvest level.
     *
     * @return did 6.
     */
    @Override
    public int getLevel() {
        return 6;
    }

    /**
     * Get the enchantability.
     *
     * @return the enchantability, always positive infinity.
     */
    @Override
    public int getEnchantmentValue() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the repair material.
     *
     * @return an ingredient instance containing the master ingot item.
     */
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.MASTER_INGOT.get());
    }
}