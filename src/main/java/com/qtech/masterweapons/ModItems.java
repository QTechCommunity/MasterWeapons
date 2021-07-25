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
    public static final RegistryObject<SwordItem> MASTER_SWORD = register("master_sword", MasterSword::new);
    public static final RegistryObject<AxeItem> MASTER_AXE = register("master_axe", MasterAxe::new);
    public static final RegistryObject<PickaxeItem> MASTER_PICKAXE = register("master_pickaxe", MasterPickaxe::new);
    public static final RegistryObject<ShovelItem> MASTER_SHOVEL = register("master_shovel", MasterShovel::new);
    public static final RegistryObject<HoeItem> MASTER_HOE = register("master_hoe", MasterHoe::new);
    public static final RegistryObject<ArmorItem> MASTER_HELMET = register("master_helmet", () -> new MasterArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<ArmorItem> MASTER_CHESTPLATE = register("master_chestplate", () -> new MasterArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<ArmorItem> MASTER_LEGGINGS = register("master_leggings", () -> new MasterArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<ArmorItem> MASTER_BOOTS = register("master_boots", () -> new MasterArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> RAW_MASTER_CORE = register("raw_master_core", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
    public static final RegistryObject<Item> MASTER_INGOT = register("master_ingot", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
    public static final RegistryObject<Item> MASTER_NUGGET = register("master_nugget", () -> new Item(new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));

    static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }
}
