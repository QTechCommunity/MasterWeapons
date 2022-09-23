package com.ultreon.masterweapons.mixin;

import com.ultreon.masterweapons.common.UltranArmorBase;
import com.ultreon.masterweapons.common.UltranToolBase;
import com.ultreon.masterweapons.common.UltranWeaponBase;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin for {@link EnchantmentHelper}
 * This mixin is meant to intercept enchantment level checks for ultran tools and weapons.
 */
@Mixin(EnchantmentHelper.class)
public class EnchantmentHelperMixin {
    @Inject(method = "getEnchantmentLevel(Lnet/minecraft/world/item/enchantment/Enchantment;Lnet/minecraft/world/entity/LivingEntity;)I", at = @At("RETURN"), cancellable = true)
    private static void master_weapons$getEnchantmentLevel(Enchantment pEnchantment, LivingEntity pEntity, CallbackInfoReturnable<Integer> cir) {
        ItemStack itemInHand = pEntity.getItemInHand(InteractionHand.MAIN_HAND);
        if (itemInHand.getItem() instanceof UltranWeaponBase) {
            if (pEnchantment == Enchantments.MOB_LOOTING) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.SWEEPING_EDGE) {
                cir.setReturnValue(5);
            } else if (pEnchantment == Enchantments.FIRE_ASPECT) {
                cir.setReturnValue(2);
            } else if (pEnchantment == Enchantments.KNOCKBACK) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.UNBREAKING) {
                cir.setReturnValue(10);
            }
        } else if (itemInHand.getItem() instanceof UltranToolBase) {
            if (pEnchantment == Enchantments.BLOCK_FORTUNE) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.BLOCK_EFFICIENCY) {
                cir.setReturnValue(100);
            } else if (pEnchantment == Enchantments.MENDING) {
                cir.setReturnValue(1);
            } else if (pEnchantment == Enchantments.UNBREAKING) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.FIRE_ASPECT) {
                cir.setReturnValue(2);
            } else if (pEnchantment == Enchantments.KNOCKBACK) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.SWEEPING_EDGE) {
                cir.setReturnValue(5);
            } else if (pEnchantment == Enchantments.MOB_LOOTING) {
                cir.setReturnValue(10);
            }
        } else if (itemInHand.getItem() instanceof UltranArmorBase) {
            if (itemInHand.getItem() instanceof ArmorItem armor) {
                EquipmentSlot equipmentSlot = armor.getEquipmentSlot(itemInHand);
                if (equipmentSlot == null) return;
                switch (equipmentSlot) {
                    case HEAD -> {
                        if (pEnchantment == Enchantments.AQUA_AFFINITY) {
                            cir.setReturnValue(1);
                        } else if (pEnchantment == Enchantments.RESPIRATION) {
                            cir.setReturnValue(5);
                        }
                    }
                    case FEET -> {
                        if (pEnchantment == Enchantments.FALL_PROTECTION) {
                            cir.setReturnValue(100);
                        } else if (pEnchantment == Enchantments.DEPTH_STRIDER) {
                            cir.setReturnValue(10);
                        }
                    }
                }
            }

            if (pEnchantment == Enchantments.MENDING) {
                cir.setReturnValue(1);
            } else if (pEnchantment == Enchantments.UNBREAKING) {
                cir.setReturnValue(10);
            } else if (pEnchantment == Enchantments.THORNS) {
                cir.setReturnValue(100);
            } else if (pEnchantment == Enchantments.ALL_DAMAGE_PROTECTION) {
                cir.setReturnValue(100);
            }
        }
    }
}
