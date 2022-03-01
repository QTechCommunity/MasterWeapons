package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ModBlocks {
    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MasterWeapons.MOD_ID);

    public static final RegistryObject<Block> MASTER_BLOCK = register("master_block", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> RAW_MASTER_BLOCK = register("raw_master_block", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> MASTER_ORE = register("master_ore", () -> new Block(Block.Properties.of(Material.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_MASTER_ORE = register("deepslate_master_ore", () -> new Block(Block.Properties.of(Material.STONE)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier) {
        RegistryObject<T> registryObject = REGISTER.register(name, supplier);
        ModItems.register(name, () -> new CustomBlockItem(registryObject::get, new Item.Properties().tab(MasterWeapons.ITEM_GROUP)));
        return registryObject;
    }

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
    }
}
