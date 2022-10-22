package com.ultreon.mods.masterweapons.fabric;

import com.ultreon.mods.masterweapons.MasterWeapons;
import net.fabricmc.api.ModInitializer;

public class MasterWeaponsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        MasterWeapons.get().init();
    }
}
