package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.items.*;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

/**
 * Item initialization class.
 *
 * @author Qboi123
 * @see Item
 * @since 2.0.0
 */
@SuppressWarnings("unused")
public class ModItems {
    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registries.ITEM);
    public static final RegistrySupplier<SwordItem> ULTRAN_SWORD = register("ultran_sword", UltranSword::new);
    public static final RegistrySupplier<AxeItem> ULTRAN_AXE = register("ultran_axe", UltranAxe::new);
    public static final RegistrySupplier<PickaxeItem> ULTRAN_PICKAXE = register("ultran_pickaxe", UltranPickaxe::new);
    public static final RegistrySupplier<ShovelItem> ULTRAN_SHOVEL = register("ultran_shovel", UltranShovel::new);
    public static final RegistrySupplier<HoeItem> ULTRAN_HOE = register("ultran_hoe", UltranHoe::new);
    public static final RegistrySupplier<ArmorItem> ULTRAN_HELMET = register("ultran_helmet", () -> new UltranArmor(EquipmentSlot.HEAD));
    public static final RegistrySupplier<ArmorItem> ULTRAN_CHESTPLATE = register("ultran_chestplate", () -> new UltranArmor(EquipmentSlot.CHEST));
    public static final RegistrySupplier<ArmorItem> ULTRAN_LEGGINGS = register("ultran_leggings", () -> new UltranArmor(EquipmentSlot.LEGS));
    public static final RegistrySupplier<ArmorItem> ULTRAN_BOOTS = register("ultran_boots", () -> new UltranArmor(EquipmentSlot.FEET));
    public static final RegistrySupplier<ArrowItem> ULTRAN_ARROW = register("ultran_arrow", () -> new UltranArrowItem(new Item.Properties()));

    public static final RegistrySupplier<Item> RAW_ULTRAN = register("raw_ultran", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ULTRAN_INGOT = register("ultran_ingot", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> ULTRAN_NUGGET = register("ultran_nugget", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<BlockItem> ULTRAN_BLOCK = register("ultran_block", () -> new BlockItem(ModBlocks.ULTRAN_BLOCK.get(), new Item.Properties()));
    public static final RegistrySupplier<BlockItem> RAW_ULTRAN_BLOCK = register("raw_ultran_block", () -> new BlockItem(ModBlocks.RAW_ULTRAN_BLOCK.get(), new Item.Properties()));
    public static final RegistrySupplier<BlockItem> ULTRAN_ORE = register("ultran_ore", () -> new BlockItem(ModBlocks.ULTRAN_ORE.get(), new Item.Properties()));
    public static final RegistrySupplier<BlockItem> DEEPSLATE_ULTRAN_ORE = register("deepslate_ultran_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_ULTRAN_ORE.get(), new Item.Properties()));

    @SuppressWarnings({"unchecked", "UnstableApiUsage"})
    static <T extends Item> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }

    /**
     * Registers all items.
     */
    public static void register() {
        REGISTER.register();
    }
}
