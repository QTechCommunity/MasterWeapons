package com.ultreon.mods.masterweapons.items.creativetab;

import com.ultreon.mods.masterweapons.init.ModBlocks;
import com.ultreon.mods.masterweapons.init.ModItems;
import dev.architectury.registry.CreativeTabOutput;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CreativeTabModifiers {
    public static void modifyCreativeTabs() {
        CreativeTabRegistry.modify(CreativeModeTabs.COMBAT, CreativeTabModifiers::addCombatItems);
        CreativeTabRegistry.modify(CreativeModeTabs.TOOLS_AND_UTILITIES, CreativeTabModifiers::addToolsAndUtilities);
        CreativeTabRegistry.modify(CreativeModeTabs.NATURAL_BLOCKS, CreativeTabModifiers::addNaturalBlocks);
        CreativeTabRegistry.modify(CreativeModeTabs.BUILDING_BLOCKS, CreativeTabModifiers::addBuildingBlocks);
        CreativeTabRegistry.modify(CreativeModeTabs.INGREDIENTS, CreativeTabModifiers::addIngredients);
    }

    private static void addNaturalBlocks(FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) {
        output.acceptAllAfter(Items.DEEPSLATE_DIAMOND_ORE, List.of(
                new ItemStack(ModBlocks.DEEPSLATE_ULTRAN_ORE.get()),
                new ItemStack(ModBlocks.ULTRAN_ORE.get())
        ));
        output.acceptAfter(Items.RAW_GOLD_BLOCK, ModBlocks.RAW_ULTRAN_BLOCK.get());
    }

    private static void addBuildingBlocks(FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) {
        output.acceptAfter(Items.NETHERITE_BLOCK, ModBlocks.ULTRAN_BLOCK.get());
    }

    private static void addIngredients(FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) {
        output.acceptAfter(Items.NETHERITE_INGOT, ModItems.ULTRAN_INGOT.get());
        output.acceptAfter(Items.GOLD_NUGGET, ModItems.ULTRAN_NUGGET.get());
        output.acceptAfter(Items.RAW_GOLD, ModItems.RAW_ULTRAN.get());
    }

    private static void addToolsAndUtilities(FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) {
        output.acceptAllAfter(Items.NETHERITE_HOE, List.of(
                new ItemStack(ModItems.ULTRAN_HOE.get()),
                new ItemStack(ModItems.ULTRAN_AXE.get()),
                new ItemStack(ModItems.ULTRAN_PICKAXE.get()),
                new ItemStack(ModItems.ULTRAN_SHOVEL.get())
        ));
    }

    private static void addCombatItems(FeatureFlagSet flags, CreativeTabOutput output, boolean canUseGameMasterBlocks) {
        output.acceptAfter(Items.NETHERITE_SWORD, ModItems.ULTRAN_SWORD.get());
        output.acceptAfter(Items.NETHERITE_AXE, ModItems.ULTRAN_AXE.get());
        output.acceptAllAfter(Items.NETHERITE_BOOTS, List.of(
                new ItemStack(ModItems.ULTRAN_BOOTS.get()),
                new ItemStack(ModItems.ULTRAN_LEGGINGS.get()),
                new ItemStack(ModItems.ULTRAN_CHESTPLATE.get()),
                new ItemStack(ModItems.ULTRAN_HELMET.get())
        ));
    }

}
