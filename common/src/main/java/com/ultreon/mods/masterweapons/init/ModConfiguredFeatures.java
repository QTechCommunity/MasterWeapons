package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;

import java.util.List;

/**
 * Configured features initialization class.
 *
 * @author Qboi123
 * @see ConfiguredFeature
 * @since 3.0.0
 */
public class ModConfiguredFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registry.CONFIGURED_FEATURE_REGISTRY);

    /**
     * Configured feature for ultran ore.
     */
    public static final RegistrySupplier<ConfiguredFeature<?, ?>> ULTRAN_ORE = REGISTER.register("ultran_ore", () -> new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK, new ReplaceBlockConfiguration(List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ULTRAN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ULTRAN_ORE.get().defaultBlockState())
    ))));

    /**
     * Registers all configured features.
     */
    public static void register() {
        REGISTER.register();
    }
}
