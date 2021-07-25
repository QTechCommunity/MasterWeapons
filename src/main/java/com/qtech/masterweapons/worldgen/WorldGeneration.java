package com.qtech.masterweapons.worldgen;

import com.google.common.collect.ImmutableList;
import com.qtech.masterweapons.MasterWeapons;
import com.qtech.masterweapons.ModBlocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Qboi123
 */
@Mod.EventBusSubscriber(modid = MasterWeapons.MOD_ID)
public class WorldGeneration {
    private static ConfiguredFeature<?, ?> feature;
    private static boolean initialized = false;
    private static ImmutableList<OreConfiguration.TargetBlockState> oreMasterTargetList;

    private WorldGeneration() {
        throw new UnsupportedOperationException("Tried to initialize constructor of utility class.");
    }

    /**
     * Biome loader.
     *
     * @param event a biome loading event.
     */
    @SubscribeEvent
    public static void generate(BiomeLoadingEvent event) {
        if (!initialized) {
            oreMasterTargetList = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.MASTER_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MASTER_ORE.get().defaultBlockState()));
//            feature = Feature.EMERALD_ORE
//                    .withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), ModBlocks.MASTER_ORE.get().getDefaultState()))
//                    .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
//                    .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 21)))
//                    .withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));
            feature = Feature.REPLACE_SINGLE_BLOCK.configured(new ReplaceBlockConfiguration(oreMasterTargetList)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15)).squared();

            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            initialized = true;
        }
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, feature);
    }
}