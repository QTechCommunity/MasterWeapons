package com.ultreon.mods.masterweapons.client;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.client.renderer.entity.UltranArrowRenderer;
import com.ultreon.mods.masterweapons.init.ModEntities;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.minecraft.client.Minecraft;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Client side initialization events.
 *
 * @author XyperCode
 * @since 3.0.0
 */
public class ClientInitialization {
    private static final Marker MARKER = MarkerFactory.getMarker("ClientInit");
    public static final ClientInitialization instance = new ClientInitialization();

    private ClientInitialization() {
        ClientLifecycleEvent.CLIENT_SETUP.register(this::clientSetup);
        registerEntityRenderers();
    }

    public static void nopInit() {
        // NOP
    }

    /**
     * Handle client setup.
     *
     * @param minecraft the Minecraft client instance.
     * @since 3.0.0
     */
    public void clientSetup(final Minecraft minecraft) {
        MasterWeapons.LOGGER.info(MARKER, "Master Weapons mod on client setup.");
    }

    /**
     * Register entity renderers.
     * Used for registering entity renderers.
     *
     * @since 3.0.0
     */
    public void registerEntityRenderers() {
        MasterWeapons.LOGGER.info(MARKER, "Registering entity renderers.");
        EntityRendererRegistry.register(() -> ModEntities.ULTRAN_ARROW.toOptional().orElseThrow(), UltranArrowRenderer::new);
    }
}
