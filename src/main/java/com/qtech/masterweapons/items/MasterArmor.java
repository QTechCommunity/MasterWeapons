package com.qtech.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

import java.util.UUID;

import static com.qtech.masterweapons.Constants.ARMOR_PROPERTY;

public class MasterArmor extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    public MasterArmor(EquipmentSlotType slot) {
        super(MasterArmorMaterial.getInstance(), slot, ARMOR_PROPERTY);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        if (this.slot == EquipmentSlotType.HEAD) {
            stack.addEnchantment(Enchantments.AQUA_AFFINITY, 1);
            stack.addEnchantment(Enchantments.RESPIRATION, 5);
        }
        if (this.slot == EquipmentSlotType.FEET) {
            stack.addEnchantment(Enchantments.DEPTH_STRIDER, 5);
            stack.addEnchantment(Enchantments.FROST_WALKER, 5);
            stack.addEnchantment(Enchantments.FEATHER_FALLING, 8);
        }
        stack.addEnchantment(Enchantments.THORNS, 10);
        super.onCreated(stack, worldIn, playerIn);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == this.slot) {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            if (this.slot == EquipmentSlotType.LEGS) {
                multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Movement speed", 0.5d, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.CHEST) {
                multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Maximum health", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.FEET) {
                multimap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Knockback resistance", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.HEAD) {
                multimap.put(SharedMonsterAttributes.LUCK.getName(), new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Lucky boy", 4096d, AttributeModifier.Operation.ADDITION));
            }
        }
        return multimap;
    }
}