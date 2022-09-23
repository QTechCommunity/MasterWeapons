package com.ultreon.mods.masterweapons.fabric;

import com.ultreon.mods.masterweapons.ExampleMod;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
    }
}
