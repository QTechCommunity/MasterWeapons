package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * Configured features initialization class.
 *
 * @author Qboi123
 * @see ConfiguredFeature
 * @since 3.2.0
 */
public class ModConfiguredFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registries.CONFIGURED_FEATURE);

    /**
     * Configured feature for ultran ore.
     */
    public static final RegistrySupplier<ConfiguredFeature<?, ?>> ULTRAN_ORE = REGISTER.register("ultran_ore", () -> new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK, new ReplaceBlockConfiguration(List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.ULTRAN_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_ULTRAN_ORE.get().defaultBlockState())
    ))));

    /**
     * Registers all configured features.
     */
    public static void register() {
        REGISTER.register();
    }
}
