package com.qtech.masterweapons;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Master Weapons main mod class.
 *
 * @author Qboi123
 */
@Mod(MasterWeapons.MOD_ID)
public class MasterWeapons {
    public static final String MOD_ID = "masterweapons";
    public static final String MOD_NAME = "Master Weapons";
    public static final CreativeModeTab ITEM_GROUP = new MasterWeaponsTab();
    public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

    /**
     * DO NOT INVOKE
     */
    public MasterWeapons() {
        LOGGER.info("Just loaded Master Weapons Mod initializer.");

        // Registering event handlers to mod eventbus.
        LOGGER.info("Registering event handlers to mod eventbus.");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::serverSetup);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        ModItems.REGISTER.register(modEventBus);
        ModBlocks.REGISTER.register(modEventBus);

        // Registering event handlers to forge eventbus.
        LOGGER.info("Registering event handlers to forge eventbus.");
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.register(this);
    }

    /**
     * Server setup handler.
     * Used for initializing non-graphical side.
     *
     * @param event an {@link FMLDedicatedServerSetupEvent} object.
     */
    private void serverSetup(final FMLDedicatedServerSetupEvent event) {
        LOGGER.info("Master Weapons mod on dedicated server setup.");
    }

    /**
     * Common setup handler.
     * Used for dual sided initialization. (Client & server.)
     *
     * @param event an {@link FMLCommonSetupEvent} object.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Master Weapons mod on generic setup.");
    }

    /**
     * Client setup handler.
     * Used for initializing graphical side.
     *
     * @param event an {@link FMLClientSetupEvent} object.
     */
    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Master Weapons mod on client setup.");
    }

    /**
     * Server starting handler.
     *
     * @param event an {@link FMLServerStartingEvent} object.
     */
    @SubscribeEvent
    public void serverStart(FMLServerStartingEvent event) {
        LOGGER.info("Server starting with Master Weapons!");
    }

    /**
     * The Master Weapons mod item group (tab).
     *
     * @author Qboi123
     */
    @ParametersAreNonnullByDefault
    @MethodsReturnNonnullByDefault
    private static class MasterWeaponsTab extends CreativeModeTab {
        public MasterWeaponsTab() {
            super("master_weapons");
        }

        /**
         * Create the icon for the item group.
         *
         * @return an item stack for the icon.
         */
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MASTER_SWORD.get());
        }
    }
}