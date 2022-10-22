package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.ModBlockItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

/**
 * Block initialization class.
 *
 * @author Qboi123
 * @see Block
 * @since 2.0.0
 */
@SuppressWarnings("unused")
public class ModBlocks {
    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registry.BLOCK_REGISTRY);

    public static final RegistrySupplier<Block> ULTRAN_BLOCK = register("ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> RAW_ULTRAN_BLOCK = register("raw_ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> ULTRAN_ORE = register("ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> DEEPSLATE_ULTRAN_ORE = register("deepslate_ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
        RegistrySupplier<T> registryObject = REGISTER.register(name, supplier);
        ModItems.register(name, () -> new ModBlockItem(registryObject, new Item.Properties().tab(MasterWeapons.getTab())));
        return registryObject;
    }

    /**
     * Registers all blocks.
     *
     * @author Qboi123
     * @since 3.0.0
     */
    public static void register() {
        REGISTER.register();
    }
}