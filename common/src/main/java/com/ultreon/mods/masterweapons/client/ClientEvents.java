package com.ultreon.mods.masterweapons.client;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * Client side events.
 *
 * @author Qboi123
 * @since 3.0.0
 */

@SuppressWarnings("InstantiationOfUtilityClass")
public class ClientEvents {
    private static final Marker MARKER = MarkerFactory.getMarker("ClientEvents");
    private static final ClientEvents INSTANCE = new ClientEvents();

    private ClientEvents() {

    }

    public static void nopInit() {

    }
}
