package com.qtech.masterweapons;

import net.minecraft.item.Item;

import java.util.UUID;

public class Constants {
    public static final Item.Properties TOOL_PROPERTY = new Item.Properties().group(MasterWeapons.ITEM_GROUP).maxStackSize(1);
    public static final Item.Properties ARMOR_PROPERTY = new Item.Properties().group(MasterWeapons.ITEM_GROUP).maxStackSize(1);
    public static final UUID ATTACK_KNOCKBACK_MODIFIER = UUID.nameUUIDFromBytes("MasterItem.KNOCKBACK_MODIFIER".getBytes());
}