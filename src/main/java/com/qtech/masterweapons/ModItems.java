package com.qtech.masterweapons;

import com.qtech.masterweapons.items.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MasterWeapons.MOD_ID);
    public static final RegistryObject<SwordItem> ULTREON_SWORD = register("ultreon_sword", MasterSword::new);
    public static final RegistryObject<AxeItem> ULTREON_AXE = register("ultreon_axe", MasterAxe::new);
    public static final RegistryObject<PickaxeItem> ULTREON_PICKAXE = register("ultreon_pickaxe", MasterPickaxe::new);
    public static final RegistryObject<ShovelItem> ULTREON_SHOVEL = register("ultreon_shovel", MasterShovel::new);
    public static final RegistryObject<HoeItem> ULTREON_HOE = register("ultreon_hoe", MasterHoe::new);
    public static final RegistryObject<ArmorItem> ULTREON_HELMET = register("ultreon_helmet", () -> new MasterArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<ArmorItem> ULTREON_CHESTPLATE = register("ultreon_chestplate", () -> new MasterArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<ArmorItem> ULTREON_LEGGINGS = register("ultreon_leggings", () -> new MasterArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<ArmorItem> ULTREON_BOOTS = register("ultreon_boots", () -> new MasterArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> RAW_ULTREON = register("raw_ultreon", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
    public static final RegistryObject<Item> ULTREON_INGOT = register("ultreon_ingot", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
    public static final RegistryObject<Item> ULTREON_NUGGET = register("ultreon_nugget", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));

    static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }
}
