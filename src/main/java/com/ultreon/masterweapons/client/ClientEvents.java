package com.ultreon.masterweapons.client;

import com.ultreon.masterweapons.MasterWeapons;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Client side events.
 *
 * @author Qboi123
 * @since 3.0.0
 */
@EventBusSubscriber(modid = MasterWeapons.MOD_ID, bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {
    private static final Marker MARKER = MarkerFactory.getMarker("ClientEvents");
}
