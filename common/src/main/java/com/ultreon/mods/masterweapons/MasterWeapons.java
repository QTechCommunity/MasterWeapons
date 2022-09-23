package com.ultreon.mods.masterweapons;

import com.ultreon.mods.masterweapons.init.*;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Master Weapons main mod class.
 *
 * @author Qboi123
 */
public class MasterWeapons {
    public static final String MOD_ID = "masterweapons";
    public static final String MOD_NAME = "Master Weapons";
    private static CreativeModeTab tab;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    private static final Marker INIT_MARKER = MarkerFactory.getMarker("Init");
    private static final Marker LOAD_MARKER = MarkerFactory.getMarker("Load");
    private static final Marker SETUP_MARKER = MarkerFactory.getMarker("Setup");
    private static final Marker CLIENT_MARKER = MarkerFactory.getMarker("Client");
    private static final Marker SERVER_MARKER = MarkerFactory.getMarker("Server");

    public static CreativeModeTab getTab() {
        return tab;
    }

    /**
     * DO NOT INVOKE, THIS IS FOR MOD LOADING ONLY.
     * <p>
     * This method is called by Forge when the mod is loaded.
     * </p>
     */
    public MasterWeapons() {
        LOGGER.info(INIT_MARKER, "Just loaded Master Weapons Mod initializer.");

        // Registering event handlers to mod eventbus.
        LOGGER.info(INIT_MARKER, "Registering event handlers to mod eventbus.");

        // Registering items and blocks to mod eventbus.
        ModItems.register();
        ModBlocks.register();
        ModPlacedFeatures.register();
        ModConfiguredFeatures.register();
        ModEntities.register();

        // Initialized.
        LOGGER.info(INIT_MARKER, "Initialized Master Weapons Mod.");

        tab = CreativeTabRegistry.create(res(MOD_ID), () -> new ItemStack(ModItems.ULTRAN_SWORD.get()));
    }

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}