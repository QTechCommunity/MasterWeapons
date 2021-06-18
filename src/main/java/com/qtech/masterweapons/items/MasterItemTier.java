package com.qtech.masterweapons.items;

import com.qtech.masterweapons.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

/**
 * Master item tier.
 *
 * @author Qboi123
 */
public class MasterItemTier implements IItemTier {
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
    public int getMaxUses() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the destroy speed / efficiency.
     * 
     * @return the block destroy speed, always positive infinity.
     */
    @Override
    public float getEfficiency() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the attack damage.
     * 
     * @return the attack damage, always positive infinity.
     */
    @Override
    public float getAttackDamage() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the harvest level.
     * 
     * @return did 6.
     */
    @Override
    public int getHarvestLevel() {
        return 6;
    }

    /**
     * Get the enchantability.
     * 
     * @return the enchantability, always positive infinity.
     */
    @Override
    public int getEnchantability() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the repair material.
     * 
     * @return an ingredient instance containing the master ingot item.
     */
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ModItems.MASTER_INGOT.get());
    }
}