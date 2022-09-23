package com.ultreon.mods.masterweapons.client;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.client.renderer.entity.UltranArrowRenderer;
import com.ultreon.mods.masterweapons.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Client side initialization events.
 *
 * @author Qboi123
 * @since 3.0.0
 */
@EventBusSubscriber(modid = MasterWeapons.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    private static final Marker MARKER = MarkerFactory.getMarker("ClientInit");

    /**
     * Client setup handler.
     * Used for initializing graphical side.
     *
     * @param event an {@link FMLClientSetupEvent} object.
     * @since 3.0.0
     */
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        MasterWeapons.LOGGER.info(MARKER, "Master Weapons mod on client setup.");
    }

    /**
     * Client setup handler.
     * Used for initializing graphical side.
     *
     * @param event an {@link FMLClientSetupEvent} object.
     * @since 3.0.0
     */
    @SubscribeEvent
    public static void loadComplete(final FMLLoadCompleteEvent event) {
        MasterWeapons.LOGGER.info(MARKER, "Master Weapons fully loaded on client.");
    }

    /**
     * Entity renderers registration handler/.
     * Used for registering entity renderers.
     *
     * @param event an {@link EntityRenderersEvent.RegisterRenderers} object.
     * @since 3.0.0
     */
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        MasterWeapons.LOGGER.info(MARKER, "Registering entity renderers.");
        event.registerEntityRenderer(ModEntities.ULTRAN_ARROW.get(), UltranArrowRenderer::new);
    }
}
