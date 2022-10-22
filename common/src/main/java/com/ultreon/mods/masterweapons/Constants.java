package com.ultreon.mods.masterweapons;

import net.minecraft.world.item.Item;

import java.util.UUID;

public class Constants {
    public static final Item.Properties TOOL_PROPERTY = new Item.Properties().tab(MasterWeapons.getTab()).stacksTo(1).durability(-1);
    public static final Item.Properties ARMOR_PROPERTY = new Item.Properties().tab(MasterWeapons.getTab()).stacksTo(1).durability(-1);
    public static final UUID BASE_ATTACK_KNOCKBACK_UUID = UUID.nameUUIDFromBytes("MasterItem.KNOCKBACK_MODIFIER".getBytes());
}