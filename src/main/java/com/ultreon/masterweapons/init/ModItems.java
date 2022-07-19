package com.ultreon.masterweapons.init;

import com.ultreon.masterweapons.MasterWeapons;
import com.ultreon.masterweapons.items.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModItems {
    static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MasterWeapons.MOD_ID);
    public static final RegistryObject<SwordItem> ULTRAN_SWORD = register("ultran_sword", UltranSword::new);
    public static final RegistryObject<AxeItem> ULTRAN_AXE = register("ultran_axe", UltranAxe::new);
    public static final RegistryObject<PickaxeItem> ULTRAN_PICKAXE = register("ultran_pickaxe", UltranPickaxe::new);
    public static final RegistryObject<ShovelItem> ULTRAN_SHOVEL = register("ultran_shovel", UltranShovel::new);
    public static final RegistryObject<HoeItem> ULTRAN_HOE = register("ultran_hoe", UltranHoe::new);
    public static final RegistryObject<ArmorItem> ULTRAN_HELMET = register("ultran_helmet", () -> new UltranArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<ArmorItem> ULTRAN_CHESTPLATE = register("ultran_chestplate", () -> new UltranArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<ArmorItem> ULTRAN_LEGGINGS = register("ultran_leggings", () -> new UltranArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<ArmorItem> ULTRAN_BOOTS = register("ultran_boots", () -> new UltranArmor(EquipmentSlot.FEET));

    public static final RegistryObject<Item> RAW_ULTRAN = register("raw_ultran", () -> new Item(new Item.Properties().tab(MasterWeapons.TAB)));
    public static final RegistryObject<Item> ULTRAN_INGOT = register("ultran_ingot", () -> new Item(new Item.Properties().tab(MasterWeapons.TAB)));
    public static final RegistryObject<Item> ULTRAN_NUGGET = register("ultran_nugget", () -> new Item(new Item.Properties().tab(MasterWeapons.TAB)));

    static <T extends Item> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
