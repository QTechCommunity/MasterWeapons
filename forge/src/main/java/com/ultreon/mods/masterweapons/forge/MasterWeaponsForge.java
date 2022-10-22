package com.ultreon.mods.masterweapons.forge;

import com.ultreon.mods.masterweapons.MasterWeapons;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MasterWeapons.MOD_ID)
public class MasterWeaponsForge {
    public MasterWeaponsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MasterWeapons.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        MasterWeapons masterWeapons = MasterWeapons.get();
        masterWeapons.init();
    }
}
