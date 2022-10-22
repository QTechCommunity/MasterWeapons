package com.ultreon.mods.masterweapons.client.renderer.entity;

import com.ultreon.mods.masterweapons.world.entity.projectile.UltranArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class UltranArrowRenderer extends ArrowRenderer<UltranArrow> {
    public UltranArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(UltranArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        ResourceLocation registryName = Registry.ITEM.getKey(referenceItem);
        return new ResourceLocation(registryName.getNamespace(), "textures/entity/projectiles/" + registryName.getPath() + ".png");
    }
}
