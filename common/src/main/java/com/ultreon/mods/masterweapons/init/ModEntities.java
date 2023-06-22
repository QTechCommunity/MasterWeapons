
package com.ultreon.mods.masterweapons.init;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.world.entity.projectile.UltranArrow;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

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
    private static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(MasterWeapons.MOD_ID, Registries.ENTITY_TYPE);
    public static final RegistrySupplier<EntityType<UltranArrow>> ULTRAN_ARROW = register("ultran_arrow", () -> EntityType.Builder.<UltranArrow>of(UltranArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(MasterWeapons.MOD_ID + ":ultran_arrow"));

    static <T extends EntityType<?>> RegistrySupplier<T> register(String name, Supplier<T> supplier) {
        return REGISTER.register(name, supplier);
    }

    /**
     * Registers all items.
     */
    public static void register() {
        REGISTER.register();
    }
}
