package com.qtech.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.qtech.masterweapons.Constants.ATTACK_KNOCKBACK_MODIFIER;
import static com.qtech.masterweapons.Constants.TOOL_PROPERTY;

/**
 * @see MasterItemTier
 * @author Qboi123
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MasterSword extends SwordItem {
    /**
     * Constructor
     */
    public MasterSword() {
        super(MasterItemTier.getInstance(), (int) Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, TOOL_PROPERTY);
    }

    /**
     * On create event.
     *
     * @param stack    item stack that is created.
     * @param worldIn  the world where the stack is created.
     * @param playerIn the player that created it.
     */
    @Override
    public void onCraftedBy(ItemStack stack, Level worldIn, Player playerIn) {
        stack.enchant(Enchantments.SWEEPING_EDGE, 10);
        stack.enchant(Enchantments.FIRE_ASPECT, 2);
        stack.enchant(Enchantments.MOB_LOOTING, 3);
        super.onCraftedBy(stack, worldIn, playerIn);
    }

    /**
     * Master tools and weapons are unbreakable.
     *
     * @return false.
     */
    @Override
    public boolean canBeDepleted() {
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
     * Get the attack damage.
     *
     * @return the attack damage: positive infinity.
     */
    @Override
    public float getDamage() {
        return Float.POSITIVE_INFINITY;
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
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(ATTACK_KNOCKBACK_MODIFIER, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }
}