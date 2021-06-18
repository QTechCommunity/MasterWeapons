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
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.world.World;

import static com.qtech.masterweapons.Constants.ATTACK_KNOCKBACK_MODIFIER;
import static com.qtech.masterweapons.Constants.TOOL_PROPERTY;

/**
 * @see MasterItemTier
 * @author Qboi123
 */
public class MasterShovel extends ShovelItem {
    /**
     * Constructor
     */
    public MasterShovel() {
        super(MasterItemTier.getInstance(), Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, TOOL_PROPERTY);
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
        stack.addEnchantment(Enchantments.FORTUNE, 5);
        super.onCreated(stack, worldIn, playerIn);
    }

    /**
     * Master tools and weapons are unbreakable.
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
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ATTACK_KNOCKBACK_MODIFIER, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }
}