package com.qtech.masterweapons.items;

import com.qtech.masterweapons.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class MasterArmorMaterial implements IArmorMaterial {
    private static final MasterArmorMaterial instance = new MasterArmorMaterial();

    public static MasterArmorMaterial getInstance() {
        return instance;
    }

    private MasterArmorMaterial() {
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public int getEnchantability() {
        return (int) Float.POSITIVE_INFINITY;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ModItems.MASTER_INGOT.get());
    }

    @Override
    public String getName() {
        return "master";
    }

    @Override
    public float getToughness() {
        return Float.POSITIVE_INFINITY;
    }
}