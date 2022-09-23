package com.ultreon.masterweapons.items;

import com.ultreon.masterweapons.world.entity.projectile.UltranArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class UltranArrowItem extends ArrowItem {
    public UltranArrowItem(Properties properties) {
        super(properties);
    }

    @NotNull
    @Override
    public AbstractArrow createArrow(@NotNull Level level, @NotNull ItemStack stack, @NotNull LivingEntity shooter) {
        UltranArrow arrow = new UltranArrow(shooter, level, this);
        arrow.setBaseDamage(Double.POSITIVE_INFINITY);
        return arrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        int enchant = net.minecraft.world.item.enchantment.EnchantmentHelper.getItemEnchantmentLevel(net.minecraft.world.item.enchantment.Enchantments.INFINITY_ARROWS, bow);
        return enchant > 0 && this.getClass() == UltranArrowItem.class;
    }
}
