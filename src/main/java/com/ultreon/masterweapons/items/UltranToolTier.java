package com.ultreon.masterweapons.items;

import com.ultreon.masterweapons.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

/**
 * Master tool tier.
 *
 * @author Qboi123
 */
public class UltranToolTier implements Tier {
    /**
     * Instance
     */
    private static final UltranToolTier instance = new UltranToolTier();

    /**
     * Get the instance.
     *
     * @return the instance.
     */
    public static UltranToolTier getInstance() {
        return instance;
    }

    /**
     * Constructor for the Master Tier for tools and weapons.
     */
    private UltranToolTier() {

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
     * Get the speed to destroy a block.
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
     * Get the level of tool tier.
     *
     * @return the harvest level, is six for all tools and weapons.
     */
    @Override
    public int getLevel() {
        return 6;
    }

    /**
     * Get how enchantable the item is.
     *
     * @return the enchantment value, always positive infinity.
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
    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ULTRAN_INGOT.get());
    }
}