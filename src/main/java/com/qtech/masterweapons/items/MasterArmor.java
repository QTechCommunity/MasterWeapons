package com.qtech.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

import java.util.UUID;

import static com.qtech.masterweapons.Constants.ARMOR_PROPERTY;

/**
 * @see MasterArmorMaterial
 * @author Qboi123
 */
public class MasterArmor extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    /**
     * Constructor
     * @param slot the equipment slot for the armor.
     */
    public MasterArmor(EquipmentSlotType slot) {
        super(MasterArmorMaterial.getInstance(), slot, ARMOR_PROPERTY);
    }

    /**
     * On create event.
     *
     * @param stack item stack that is created.
     * @param worldIn the world where the stack is created.
     * @param playerIn the player that created it.
     */
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

    /**
     * Master armor pieces are unbreakable.
     *
     * @return false.
     */
    @Override
    public boolean isDamageable() {
        return false;
    }

    /**
     * Get the rarity.
     *
     * @param stack the item stack to get the rarity for.
     * @return the rarity.
     */
    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    /**
     * Get destroy speed.
     *
     * @param stack the item stack instance.
     * @param state the state of the block to check the destroy speed for.
     * @return the destroy speed/
     */
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the attribute modifiers.
     *
     * @param equipmentSlot the equipment slot to get the attribute modifiers for.
     * @return an multi-mapping for attribute to modifier.
     */
    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == this.slot) {
            multimap.put(Attributes.ARMOR, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            if (this.slot == EquipmentSlotType.LEGS) {
                multimap.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Movement speed", 0.5d, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.CHEST) {
                multimap.put(Attributes.MAX_HEALTH, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Maximum health", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.FEET) {
                multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Knockback resistance", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlotType.HEAD) {
                multimap.put(Attributes.LUCK, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Lucky boy", 4096d, AttributeModifier.Operation.ADDITION));
            }
        }
        return multimap;
    }
}