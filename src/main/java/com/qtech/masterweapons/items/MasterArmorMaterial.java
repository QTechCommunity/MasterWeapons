package com.qtech.masterweapons.items;

import com.qtech.masterweapons.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

/**
 * Master armor material.
 *
 * @author Qboi123
 */
public class MasterArmorMaterial implements IArmorMaterial {
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

    /**
     * Get the durability for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the durability, always positive infinity.
     */
    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    /**
     * Get the damage redurction for given equipment slot.
     *
     * @param slotIn the armor slot.
     * @return the damage reduction amount, always positive infinity.
     */
    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return (int) Float.POSITIVE_INFINITY;
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
     * Get the equip sound event.
     *
     * @return diamond equip sound.
     */
    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    /**
     * Get the repair material.
     *
     * @return an ingredient instance containing the master ingot item
     */
    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ModItems.MASTER_INGOT.get());
    }

    /**
     * Get the name / resource location.
     *
     * @return the resource location: <pre>masterweapons:master</pre>
     */
    @Override
    public String getName() {
        return "masterweapons:master";
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
