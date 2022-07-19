package com.ultreon.masterweapons.items;

import com.ultreon.masterweapons.MasterWeapons;
import com.ultreon.masterweapons.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

/**
 * Master armor material.
 *
 * @author Qboi123
 */
public class UltranArmorMaterial implements ArmorMaterial {
    private static final UltranArmorMaterial instance = new UltranArmorMaterial();

    /**
     * Get the instance.
     *
     * @return the instance.
     */
    public static UltranArmorMaterial getInstance() {
        return instance;
    }

    private UltranArmorMaterial() {
    }

    /**
     * Get the durability for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the durability, always positive infinity.
     */
    @Override
    public int getDurabilityForSlot(EquipmentSlot slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the damage reduction for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the damage reduction amount, always positive infinity.
     */
    @Override
    public int getDefenseForSlot(EquipmentSlot slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the enchantment value.
     *
     * @return the enchantment value, always positive infinity.
     */
    @Override
    public int getEnchantmentValue() {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the sound for equipping the armor.
     *
     * @return diamond equip sound.
     */
    @NotNull
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    /**
     * Get the ingredient to repair the item with.
     *
     * @return an ingredient instance containing the master ingot item
     */
    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ModItems.ULTRAN_INGOT.get());
    }

    /**
     * Get the type identifier.
     *
     * @return the resource location: {@code masterweapons:ultran}
     */
    @NotNull
    @Override
    public String getName() {
        return MasterWeapons.MOD_ID + ":ultran";
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
