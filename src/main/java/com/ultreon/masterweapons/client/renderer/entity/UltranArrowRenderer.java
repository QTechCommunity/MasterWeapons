package com.ultreon.masterweapons.client.renderer.entity;

import com.ultreon.masterweapons.world.entity.projectile.UltranArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class UltranArrowRenderer extends ArrowRenderer<UltranArrow> {
    public UltranArrowRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
    }

    @Override
    public ResourceLocation getTextureLocation(UltranArrow pEntity) {
        Item referenceItem = pEntity.getPickupItem().getItem();
        ResourceLocation registryName = referenceItem.getRegistryName();
        if (registryName == null) {
            return new ResourceLocation("");
        }
        return new ResourceLocation(registryName.getNamespace(), "textures/entity/projectiles/" + registryName.getPath() + ".png");
    }
}
