
package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.world.entity.projectile.UltranArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * Item initialization class.
 *
 * @author Qboi123
 * @see Item
 * @since 2.0.0
 */
@SuppressWarnings("unused")
public class ModEntities {
    private static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, MasterWeapons.MOD_ID);
    public static final RegistryObject<EntityType<UltranArrow>> ULTRAN_ARROW = register("ultran_arrow", () -> EntityType.Builder.<UltranArrow>of(UltranArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(MasterWeapons.MOD_ID + ":ultran_arrow"));

    static <T extends EntityType<?>> RegistryObject<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }

    /**
     * Registers all items.
     *
     * @param modEventBus the event bus to register the items with.
     */
    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}
