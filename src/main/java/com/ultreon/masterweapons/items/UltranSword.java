package com.ultreon.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ultreon.masterweapons.common.UltranMeleeWeaponBase;
import com.ultreon.masterweapons.init.ModRarities;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static com.ultreon.masterweapons.Constants.BASE_ATTACK_KNOCKBACK_UUID;
import static com.ultreon.masterweapons.Constants.TOOL_PROPERTY;

/**
 * @author Qboi123
 * @see UltranToolTier
 */
public class UltranSword extends SwordItem implements UltranMeleeWeaponBase {
    /**
     * Constructor
     */
    public UltranSword() {
        super(UltranToolTier.getInstance(), (int) Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, TOOL_PROPERTY);
    }

    /**
     * Master tools and weapons are unbreakable.
     *
     * @return false.
     */
    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }

    /**
     * Master tools and weapons can't be damaged.
     * And will never be damaged.
     *
     * @param stack the stack
     * @return non-damaged.
     */
    @Override
    public boolean isDamaged(ItemStack stack) {
        return false;
    }

    /**
     * Get the rarity.
     *
     * @param stack the item stack to get the rarity for.
     * @return the rarity.
     */
    @NotNull
    @Override
    public Rarity getRarity(@NotNull ItemStack stack) {
        return ModRarities.LEGENDARY;
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
     * @param state the state of the block to check the speed for destroying a block for.
     * @return the speed to destroy a block.
     */
    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
        return Float.POSITIVE_INFINITY;
    }

    /**
     * Get the attribute modifiers.
     *
     * @param equipmentSlot the equipment slot to get the attribute modifiers for.
     * @return an multi-mapping for attribute to modifier.
     */
    @NotNull
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@NotNull EquipmentSlot equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(BASE_ATTACK_KNOCKBACK_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }
}