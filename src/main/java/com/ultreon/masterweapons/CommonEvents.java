package com.ultreon.masterweapons;

import com.ultreon.masterweapons.common.UltranArmorBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MasterWeapons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {
    private static final Marker MARKER = MarkerFactory.getMarker("CommonEvents");
    private static Set<Player> flyables = new HashSet<>();

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        if (hasUltranArmor(event.getEntityLiving())) {
            event.setAmount(0);
            event.setCanceled(true);
        }
    }

    private static boolean hasUltranArmor(LivingEntity entity) {
        Iterable<ItemStack> armorSlots = entity.getArmorSlots();
        boolean hasUltranArmor = true;
        for (ItemStack stack : armorSlots) {
            hasUltranArmor &= stack.getItem() instanceof UltranArmorBase;
        }
        return hasUltranArmor;
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (hasUltranArmor(event.player)) {
            event.player.setAbsorptionAmount(80f);
            boolean mayfly = event.player.getAbilities().mayfly;
            if (!mayfly) {
                event.player.getAbilities().mayfly = true;
                event.player.onUpdateAbilities();
            }
            flyables.add(event.player);
        } else {
            if (!event.player.isCreative() && !event.player.isSpectator()) {
                boolean mayfly = event.player.getAbilities().mayfly;
                if (mayfly) {
                    event.player.getAbilities().mayfly = false;
                    event.player.getAbilities().flying = false;
                    event.player.onUpdateAbilities();
                }
            }
            flyables.remove(event.player);
        }
    }
}
