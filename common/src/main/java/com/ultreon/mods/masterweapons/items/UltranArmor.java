package com.ultreon.mods.masterweapons.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ultreon.mods.masterweapons.common.UltranArmorBase;
import com.ultreon.mods.masterweapons.init.ModRarities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static com.ultreon.mods.masterweapons.Constants.ARMOR_PROPERTY;
import static java.lang.Double.POSITIVE_INFINITY;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.*;
import static net.minecraft.world.entity.ai.attributes.Attributes.*;

/**
 * Ultran Armor
 * The ultran armor isn't your average armor. It's the most powerful armor ever. Making every being invincible with more effects.
 *
 * @author XyperCode
 * @see UltranArmorMaterial
 * @since 2.0.0
 */
public class UltranArmor extends ArmorItem implements UltranArmorBase {
    private static final UUID[] ARMOR_UUIDS = new UUID[]{UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")};

    /**
     * Constructor
     *
     * @param type the armor item type.
     * @since 2.0.0
     */
    public UltranArmor(Type type) {
        super(UltranArmorMaterial.getInstance(), type, ARMOR_PROPERTY);
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
        return ModRarities.getLegendary();
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
        return Float.MAX_VALUE;
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        if (!(entity instanceof LivingEntity living) || !living.getItemBySlot(getEquipmentSlot()).is(this)) {
            return;
        }

        switch (getEquipmentSlot()) {
            case HEAD -> tickHeadItem(living);
            case CHEST -> tickChestItem(living);
            case LEGS, FEET -> tickMisc(living);
        }
    }

    private static void tickMisc(LivingEntity living) {
        living.setStingerCount(0);
        living.setArrowCount(0);
    }

    private static void tickHeadItem(LivingEntity living) {
        tickMisc(living);

        living.setAirSupply(living.getMaxAirSupply());
    }

    private static void tickChestItem(LivingEntity living) {
        tickMisc(living);

        living.setHealth(living.getMaxHealth());
        if (living instanceof Player player) {
            FoodData foodData = player.getFoodData();
            foodData.setFoodLevel(20);
            foodData.setExhaustion(0.0F);
            foodData.setSaturation(20.0F);
        }
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
        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
        UUID armorUuid = ARMOR_UUIDS[equipmentSlot.getIndex()];
        if (equipmentSlot == this.getEquipmentSlot()) {
            modifiers.put(ARMOR, new AttributeModifier(armorUuid, "Armor modifier", POSITIVE_INFINITY, ADDITION));
            modifiers.put(ARMOR_TOUGHNESS, new AttributeModifier(armorUuid, "Armor toughness", POSITIVE_INFINITY, ADDITION));

            switch (this.getEquipmentSlot()) {
                case HEAD -> putHeadAttrs(armorUuid, modifiers);
                case LEGS -> putLegsAttrs(armorUuid, modifiers);
                case FEET -> putFeetAttrs(armorUuid, modifiers);
            }
        }
        return modifiers;
    }

    private static void putHeadAttrs(UUID uuid, Multimap<Attribute, AttributeModifier> modifiers) {
        modifiers.put(LUCK, new AttributeModifier(uuid, "Luck", 4096d, ADDITION));
    }

    private static void putFeetAttrs(UUID uuid, Multimap<Attribute, AttributeModifier> modifiers) {
        modifiers.put(KNOCKBACK_RESISTANCE, new AttributeModifier(uuid, "Knockback resistance", POSITIVE_INFINITY, ADDITION));
    }

    private static void putLegsAttrs(UUID uuid, Multimap<Attribute, AttributeModifier> modifiers) {
        modifiers.put(MOVEMENT_SPEED, new AttributeModifier(uuid, "Movement speed", 0.2d, ADDITION));
    }
}