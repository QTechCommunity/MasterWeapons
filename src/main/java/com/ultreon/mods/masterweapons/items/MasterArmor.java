package com.ultreon.mods.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ultreon.mods.masterweapons.Constants;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

/**
 * @author Qboi123
 * @see MasterArmorMaterial
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MasterArmor extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    /**
     * Constructor
     *
     * @param slot the equipment slot for the armor.
     */
    public MasterArmor(EquipmentSlot slot) {
        super(MasterArmorMaterial.getInstance(), slot, Constants.ARMOR_PROPERTY);
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
        if (this.slot == EquipmentSlot.HEAD) {
            stack.enchant(Enchantments.AQUA_AFFINITY, 1);
            stack.enchant(Enchantments.RESPIRATION, 5);
        }
        if (this.slot == EquipmentSlot.FEET) {
            stack.enchant(Enchantments.DEPTH_STRIDER, 5);
            stack.enchant(Enchantments.FROST_WALKER, 5);
            stack.enchant(Enchantments.FALL_PROTECTION, 8);
        }
        stack.enchant(Enchantments.THORNS, 10);
        super.onCraftedBy(stack, worldIn, playerIn);
    }

    /**
     * Master armor pieces are unbreakable.
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
     * Get destroy speed.
     *
     * @param stack the item stack instance.
     * @param state the state of the block to check the breaking speed for.
     * @return the breaking speed/
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
        if (equipmentSlot == this.slot) {
            multimap.put(Attributes.ARMOR, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Armor toughness", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            if (this.slot == EquipmentSlot.LEGS) {
                multimap.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Movement speed", 0.5d, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlot.CHEST) {
                multimap.put(Attributes.MAX_HEALTH, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Maximum health", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlot.FEET) {
                multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Knockback resistance", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlot.HEAD) {
                multimap.put(Attributes.LUCK, new AttributeModifier(ARMOR_MODIFIERS[equipmentSlot.getIndex()], "Lucky boy", 4096d, AttributeModifier.Operation.ADDITION));
            }
        }
        return multimap;
    }
}