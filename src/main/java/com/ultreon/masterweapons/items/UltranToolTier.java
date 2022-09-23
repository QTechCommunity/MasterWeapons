package com.ultreon.masterweapons.items;

import com.ultreon.masterweapons.init.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

/**
 * Ultran tool tier.
 *
 * @author Qboi123
 * @since 2.0.0
 */
public class UltranToolTier implements Tier {
    /**
     * Instance
     *
     * @since 2.0.0
     */
    private static final UltranToolTier instance = new UltranToolTier();

    /**
     * Get the instance.
     *
     * @return the instance.
     * @author Qboi123
     * @since 2.0.0
     */
    public static UltranToolTier getInstance() {
        return instance;
    }

    /**
     * Constructor for the Master Tier for tools and weapons.
     *
     * @author Qboi123
     * @since 2.0.0
     */
    private UltranToolTier() {

    }

    /**
     * Get the maximum amount of uses.
     *
     * @return the maximum amount of uses, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public int getUses() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the speed to destroy a block.
     *
     * @return the block destroy speed, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public float getSpeed() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the attack damage.
     *
     * @return the attack damage, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public float getAttackDamageBonus() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the level of tool tier.
     *
     * @return the harvest level, is six for all tools and weapons.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public int getLevel() {
        return 6;
    }

    /**
     * Get how enchantable the item is.
     *
     * @return the enchantment value, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public int getEnchantmentValue() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the repair material.
     *
     * @return an ingredient instance containing the master ingot item.
     * @author Qboi123
     * @since 2.0.0
     */
    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ULTRAN_INGOT.get());
    }
}