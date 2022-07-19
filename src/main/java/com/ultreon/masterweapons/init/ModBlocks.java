package com.ultreon.masterweapons.init;

import com.ultreon.masterweapons.MasterWeapons;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MasterWeapons.MOD_ID);
    public static final RegistryObject<Block> ULTRAN_BLOCK = register("ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistryObject<Block> RAW_ULTRAN_BLOCK = register("raw_ultran_block", () -> new Block(Block.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistryObject<Block> ULTRAN_ORE = register("ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));
    public static final RegistryObject<Block> DEEPSLATE_ULTRAN_ORE = register("deepslate_ultran_ore", () -> new Block(Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).requiresCorrectToolForDrops().strength(200f, 5000f)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
        RegistryObject<T> registryObject = REGISTER.register(name, supplier);
        ModItems.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().tab(MasterWeapons.TAB)));
        return registryObject;
    }

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}