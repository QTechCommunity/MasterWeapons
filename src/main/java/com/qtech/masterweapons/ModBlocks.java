package com.qtech.masterweapons;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MasterWeapons.MOD_ID);
    public static final RegistryObject<Block> MASTER_BLOCK = register("master_block", () -> new Block(Block.Properties.create(Material.ROCK)));
    public static final RegistryObject<Block> MASTER_ORE = register("master_ore", () -> new Block(Block.Properties.create(Material.ROCK)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
        RegistryObject<T> registryObject = REGISTER.register(name, supplier);
        ModItems.register(name, () -> new BlockItem(registryObject::get, new Item.Properties().group(MasterWeapons.ITEM_GROUP)));
        return registryObject;
    }
}