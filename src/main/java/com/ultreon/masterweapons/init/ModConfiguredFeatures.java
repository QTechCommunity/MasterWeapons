package com.ultreon.masterweapons.init;

import com.ultreon.masterweapons.MasterWeapons;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

/**
 * Configured features initialization class.
 *
 * @author Qboi123
 * @see ConfiguredFeature
 * @since 3.0.0
 */
public class ModConfiguredFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> REGISTER = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MasterWeapons.MOD_ID);

    /**
     * Configured feature for ultran ore.
     */
    public static final RegistryObject<ConfiguredFeature<?, ?>> ULTRAN_ORE = REGISTER.register("ultran_ore", () -> new ConfiguredFeature<>(Feature.REPLACE_SINGLE_BLOCK, new ReplaceBlockConfiguration(List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ULTRAN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ULTRAN_ORE.get().defaultBlockState())
    ))));

    /**
     * Registers all configured features.
     *
     * @param modEventBus the event bus to register the configured features with.
     */
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
