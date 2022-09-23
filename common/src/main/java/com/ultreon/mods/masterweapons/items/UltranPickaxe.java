package com.ultreon.mods.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ultreon.mods.masterweapons.common.UltranToolBase;
import com.ultreon.mods.masterweapons.init.ModRarities;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import static com.ultreon.mods.masterweapons.Constants.BASE_ATTACK_KNOCKBACK_UUID;
import static com.ultreon.mods.masterweapons.Constants.TOOL_PROPERTY;

/**
 * Ultran Pickaxe
 * This pickaxe is a destroyer of planets.
 *
 * @author Qboi123
 * @see UltranToolTier
 * @since 2.0.0
 */
public class UltranPickaxe extends PickaxeItem implements UltranToolBase {
    /**
     * Constructor
     *
     * @since 2.0.0
     */
    public UltranPickaxe() {
        super(UltranToolTier.getInstance(), (int) Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, TOOL_PROPERTY);
    }

    /**
     * Master tools and weapons are unbreakable.
     *
     * @return false.
     * @since 2.0.0
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
     * @since 3.0.0
     */
    @Override
    public boolean isDamaged(ItemStack stack) {
        return super.isDamaged(stack);
    }

    /**
     * Get the rarity.
     *
     * @param stack the item stack to get the rarity for.
     * @return the rarity.
     * @since 2.0.0
     */
    @NotNull
    @Override
    public Rarity getRarity(@NotNull ItemStack stack) {
        return ModRarities.LEGENDARY;
    }

    /**
     * Get destroy speed.
     *
     * @param stack the item stack instance.
     * @param state the state of the block to check the speed to destroy the block for.
     * @return the speed to destroy a block.
     * @since 2.0.0
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
     * @since 2.0.0
     */
    @NotNull
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        Multimap<Attribute, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlot.MAINHAND) {
            multimap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ATTACK_KNOCKBACK, new AttributeModifier(BASE_ATTACK_KNOCKBACK_UUID, "Weapon modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
        }
        return multimap;
    }

    @Override
    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return pState.is(BlockTags.MINEABLE_WITH_PICKAXE);
    }
}