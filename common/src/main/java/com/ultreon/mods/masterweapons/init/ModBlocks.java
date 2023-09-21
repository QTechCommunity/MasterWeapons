package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.ModBlockItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

/**
 * Block initialization class.
 *
 * @author XyperCode
 * @see Block
 * @since 2.0.0
 */
@SuppressWarnings("unused")
public class ModBlocks {
    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registries.BLOCK);

    public static final RegistrySupplier<Block> ULTRAN_BLOCK = register("ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> RAW_ULTRAN_BLOCK = register("raw_ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> ULTRAN_ORE = register("ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistrySupplier<Block> DEEPSLATE_ULTRAN_ORE = register("deepslate_ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));

    @SuppressWarnings({"unchecked", "UnstableApiUsage"})
    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }

    /**
     * Registers all blocks.
     *
     * @author XyperCode
     * @since 3.0.0
     */
    public static void register() {
        REGISTER.register();
    }
}