package com.ultreon.mods.masterweapons;

import com.ultreon.mods.masterweapons.client.ClientEvents;
import com.ultreon.mods.masterweapons.client.ClientInitialization;
import com.ultreon.mods.masterweapons.init.*;
import com.ultreon.mods.masterweapons.world.gen.WorldGeneration;
import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.minecraft.resources.ResourceLocation;
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
    public static final Logger LOGGER = LoggerFactory.getLogger(MasterWeapons.class.getSimpleName());
    private static final Marker INIT_MARKER = MarkerFactory.getMarker("Init");
    private static final Marker LOAD_MARKER = MarkerFactory.getMarker("Load");
    private static final Marker SETUP_MARKER = MarkerFactory.getMarker("Setup");
    private static final Marker CLIENT_MARKER = MarkerFactory.getMarker("Client");
    private static final Marker SERVER_MARKER = MarkerFactory.getMarker("Server");
    private static final MasterWeapons INSTANCE = new MasterWeapons();
    private static final CreativeTabRegistry.TabSupplier tab = CreativeTabRegistry.create(res(MOD_ID), () -> new ItemStack(ModItems.ULTRAN_SWORD.get()));
    private CommonEvents commonEvents;

    public static CreativeTabRegistry.TabSupplier getTab() {
        return tab;
    }

    /**
     * DO NOT INVOKE, THIS IS FOR MOD LOADING ONLY.
     * <p>
     * This method is called by Forge when the mod is loaded.
     * </p>
     */
    public MasterWeapons() {

    }

    public void init() {
        LOGGER.info(INIT_MARKER, "Just loaded Master Weapons Mod initializer.");

        // Registering event handlers to mod eventbus.
        LOGGER.info(INIT_MARKER, "Registering event handlers to mod eventbus.");

        // Registering items and blocks to mod eventbus.
        ModItems.register();
        ModBlocks.register();
        ModEntities.register();
        ModConfiguredFeatures.register();
        ModPlacedFeatures.register();

        // Initialized.
        LOGGER.info(INIT_MARKER, "Initialized Master Weapons Mod.");

        commonEvents = new CommonEvents();
        EnvExecutor.runInEnv(Env.CLIENT, () -> () -> {
            ClientEvents.nopInit();
            ClientInitialization.nopInit();
        });

        LifecycleEvent.SETUP.register(this::setup);
    }

    private void setup() {
        WorldGeneration.init();
    }

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public CommonEvents getCommonEvents() {
        return commonEvents;
    }

    public static MasterWeapons get() {
        return INSTANCE;
    }
}