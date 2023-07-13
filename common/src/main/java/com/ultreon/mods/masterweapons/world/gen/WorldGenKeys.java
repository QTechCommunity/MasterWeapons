package com.ultreon.mods.masterweapons.world.gen;

import com.ultreon.mods.masterweapons.MasterWeapons;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class WorldGenKeys {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ULTRAN_ORE = registerKey(Registries.CONFIGURED_FEATURE, "ultran_ore");
    public static final ResourceKey<PlacedFeature> PLACED_ULTRAN_ORE = registerKey(Registries.PLACED_FEATURE, "ultran_ore");

    private static <T> ResourceKey<T> registerKey(ResourceKey<? extends Registry<T>> registryKey, String id) {
        return ResourceKey.create(registryKey, MasterWeapons.res(id));
    }
}