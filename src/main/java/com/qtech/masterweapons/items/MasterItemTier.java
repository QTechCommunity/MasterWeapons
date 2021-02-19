package com.qtech.masterweapons.items;

import com.qtech.masterweapons.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class MasterItemTier implements IItemTier {
    private static final MasterItemTier instance = new MasterItemTier();

    public static MasterItemTier getInstance() {
        return instance;
    }

    private MasterItemTier() {
    }

    @Override
    public int getMaxUses() {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public float getEfficiency() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public float getAttackDamage() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public int getHarvestLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ModItems.MASTER_INGOT.get());
    }
}