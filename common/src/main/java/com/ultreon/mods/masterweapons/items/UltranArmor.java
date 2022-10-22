package com.ultreon.mods.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ultreon.mods.masterweapons.common.UltranArmorBase;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static com.ultreon.mods.masterweapons.Constants.ARMOR_PROPERTY;

/**
 * Ultran Armor
 * The ultran armor isn't your average armor. It's the most powerful armor ever. Making every being invincible with more effects.
 *
 * @author Qboi123
 * @see UltranArmorMaterial
 * @since 2.0.0
 */
public class UltranArmor extends ArmorItem implements UltranArmorBase {
    private static final UUID[] BASE_ARMOR_UUIDS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    /**
     * Constructor
     *
     * @param slot the equipment slot for the armor.
     * @since 2.0.0
     */
    public UltranArmor(EquipmentSlot slot) {
        super(UltranArmorMaterial.getInstance(), slot, ARMOR_PROPERTY);
    }

    /**
     * Get the rarity.
     *
     * @param stack the item stack to get the rarity for.
     * @return the rarity.
     */
    @NotNull
    @Override
    @ExpectPlatform
    public Rarity getRarity(@NotNull ItemStack stack) {
        throw new Error("Didn't implement");
    }

    /**
     * Get destroy speed.
     *
     * @param stack the item stack instance.
     * @param state the state of the block to check the speed to destroy the block for.
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
        if (equipmentSlot == this.slot) {
            multimap.put(Attributes.ARMOR, new AttributeModifier(BASE_ARMOR_UUIDS[equipmentSlot.getIndex()], "Armor modifier", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            multimap.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(BASE_ARMOR_UUIDS[equipmentSlot.getIndex()], "Armor toughness", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            if (this.slot == EquipmentSlot.LEGS) {
                multimap.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(BASE_ARMOR_UUIDS[equipmentSlot.getIndex()], "Movement speed", 0.2d, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlot.FEET) {
                multimap.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(BASE_ARMOR_UUIDS[equipmentSlot.getIndex()], "Knockback resistance", Double.POSITIVE_INFINITY, AttributeModifier.Operation.ADDITION));
            } else if (this.slot == EquipmentSlot.HEAD) {
                multimap.put(Attributes.LUCK, new AttributeModifier(BASE_ARMOR_UUIDS[equipmentSlot.getIndex()], "Lucky boy", 4096d, AttributeModifier.Operation.ADDITION));
            }
        }
        return multimap;
    }
}