package com.ultreon.mods.masterweapons.items;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

/**
 * Ultran armor material.
 *
 * @author Qboi123
 * @since 2.0.0
 */
public class UltranArmorMaterial implements ArmorMaterial {
    /**
     * The armor material instance.
     *
     * @since 2.0.0
     */
    private static final UltranArmorMaterial instance = new UltranArmorMaterial();

    /**
     * Get the instance.
     *
     * @return the instance.
     * @author Qboi123
     * @since 2.0.0
     */
    public static UltranArmorMaterial getInstance() {
        return instance;
    }

    /**
     * Constructor for the Ultran Armor Material.
     *
     * @author Qboi123
     * @since 2.0.0
     */
    private UltranArmorMaterial() {
    }

    /**
     * Get the durability for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the durability, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the damage reduction for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the damage reduction amount, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public int getDefenseForSlot(@NotNull EquipmentSlot slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the enchantment value.
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
     * Get the sound for equipping the armor.
     *
     * @return diamond equip sound.
     * @author Qboi123
     * @since 2.0.0
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
     * @author Qboi123
     * @since 2.0.0
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
     * @author Qboi123
     * @since 2.0.0
     */
    @NotNull
    @Override
    public String getName() {
        return MasterWeapons.MOD_ID + "_ultran";
    }

    /**
     * Get the armor toughness.
     *
     * @return the armor toughness, always positive infinity.
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public float getToughness() {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the knockback resistance.
     *
     * @return 1024.0f
     * @author Qboi123
     * @since 2.0.0
     */
    @Override
    public float getKnockbackResistance() {
        return 1024.0f;
    }
}
