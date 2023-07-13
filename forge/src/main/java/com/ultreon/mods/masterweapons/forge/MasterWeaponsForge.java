package com.ultreon.mods.masterweapons.forge;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.debug.Debugger;
import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MasterWeapons.MOD_ID)
public class MasterWeaponsForge {
    public MasterWeaponsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MasterWeapons.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MasterWeapons masterWeapons = MasterWeapons.get();
        masterWeapons.init();

        if (Platform.isDevelopmentEnvironment()) {
            MinecraftForge.EVENT_BUS.addListener(this::onChunkLoad);
        }
    }

    private void onChunkLoad(ChunkEvent.Load event) {
        Debugger.onChunkLoad(event.getLevel(), event.getChunk());
    }
}
