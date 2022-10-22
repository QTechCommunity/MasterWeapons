package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

/**
 * Placed features initialization class.
 *
 * @author Qboi123
 * @see PlacedFeature
 * @since 3.0.0
 */
@Deprecated
public class ModPlacedFeatures {
    private static final DeferredRegister<PlacedFeature> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registry.PLACED_FEATURE_REGISTRY);

    /**
     * Placed feature for ultran ore.
     */
    public static final RegistrySupplier<PlacedFeature> ULTRAN_ORE = REGISTER.register("ultran_ore", () -> new PlacedFeature(Holder.direct(ModConfiguredFeatures.ULTRAN_ORE.toOptional().orElseThrow()), List.of(
            CountPlacement.of(1),
            HeightRangePlacement.uniform(VerticalAnchor.TOP, VerticalAnchor.BOTTOM),
            RarityFilter.onAverageOnceEvery(64)
    )));

    /**
     * Registers all placed features.
     */
    public static void register() {
        REGISTER.register();
    }
}
