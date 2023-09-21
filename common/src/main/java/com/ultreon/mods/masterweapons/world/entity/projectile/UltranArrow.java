package com.ultreon.mods.masterweapons.world.entity.projectile;

import com.ultreon.mods.masterweapons.init.ModEntities;
import com.ultreon.mods.masterweapons.init.ModItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

public class UltranArrow extends AbstractArrow {
    private final ArrowItem referenceItem;

    public UltranArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.ULTRAN_ARROW.get();
    }

    public UltranArrow(LivingEntity shooter, Level level, ArrowItem referenceItem) {
        super(ModEntities.ULTRAN_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @NotNull
    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(referenceItem);
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult hit) {
        super.onHitEntity(hit);
        Entity entity = hit.getEntity();
        if (entity instanceof LivingEntity living) {
            Entity arrowOwner = this.getOwner();
            DamageSource damageSource;
            if (arrowOwner == null) {
                damageSource = living.level.damageSources().arrow(this, this);
            } else {
                damageSource = living.level.damageSources().arrow(this, arrowOwner);
                if (arrowOwner instanceof LivingEntity livingOwner) {
                    livingOwner.setLastHurtMob(entity);
                }
            }

            living.hurt(damageSource, Float.POSITIVE_INFINITY);
        }
    }
}
