package com.qtech.masterweapons;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MasterWeapons.MOD_ID);
    public static final RegistryObject<Block> ULTREON_BLOCK = register("ultreon_block", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> RAW_ULTREON_BLOCK = register("raw_ultreon_block", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> ULTREON_ORE = register("ultreon_ore", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_ULTREON_ORE = register("deepslate_ultreon_ore", () -> new Block(Block.Properties.of(Material.STONE)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
        RegistryObject<T> registryObject = REGISTER.register(name, supplier);
        ModItems.register(name, () -> new BlockItem(registryObject::get, new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
        return registryObject;
    }
}
