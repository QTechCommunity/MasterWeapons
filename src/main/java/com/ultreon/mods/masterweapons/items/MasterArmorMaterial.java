package com.ultreon.mods.masterweapons.items;

import com.ultreon.mods.masterweapons.init.ModItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Master armor material.
 *
 * @author Qboi123
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MasterArmorMaterial implements ArmorMaterial {
    private static final MasterArmorMaterial instance = new MasterArmorMaterial();

    /**
     * Get the instance.
     *
     * @return the instance.
     */
    public static MasterArmorMaterial getInstance() {
        return instance;
    }

    private MasterArmorMaterial() {
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot p_40410_) {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot p_40411_) {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public int getEnchantmentValue() {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.MASTER_INGOT.get());
    }

    /**
     * Get the name / resource location.
     *
     * @return the resource location: <pre>masterweapons:ultrium</pre>
     */
    @Override
    public String getName() {
        return "masterweapons:ultrium";
    }

    /**
     * Get the armor toughness.
     *
     * @return the armor toughness, always positive infinity.
     */
    @Override
    public float getToughness() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the knockback resistance.
     *
     * @return 1024.0f
     */
    @Override
    public float getKnockbackResistance() {
        return 1024.0f;
    }
}
