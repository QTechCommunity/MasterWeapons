package com.ultreon.masterweapons.init;

import com.ultreon.masterweapons.MasterWeapons;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    private static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MasterWeapons.MOD_ID);

    public static final RegistryObject<PlacedFeature> ULTRAN_ORE = REGISTER.register("ultran_ore", () -> new PlacedFeature(ModConfiguredFeatures.ULTRAN_ORE.getHolder().orElseThrow(), List.of(
            CountPlacement.of(1),
            HeightRangePlacement.uniform(VerticalAnchor.TOP, VerticalAnchor.BOTTOM),
            RarityFilter.onAverageOnceEvery(64)
    )));

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
