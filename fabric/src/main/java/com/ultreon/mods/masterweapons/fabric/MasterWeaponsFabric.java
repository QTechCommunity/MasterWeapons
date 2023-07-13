package com.ultreon.mods.masterweapons.fabric;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.debug.Debugger;
import dev.architectury.platform.Platform;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;

public class MasterWeaponsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MasterWeapons.get().init();
        if (Platform.isDevelopmentEnvironment()) {
            ServerChunkEvents.CHUNK_LOAD.register(Debugger::onChunkLoad);
        }
    }
}
