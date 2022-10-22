package com.ultreon.mods.masterweapons;

import com.ultreon.mods.masterweapons.common.UltranArmorBase;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.HashSet;
import java.util.Set;

public class CommonEvents {
    private static final Marker MARKER = MarkerFactory.getMarker("CommonEvents");
    private static Set<Player> flyables = new HashSet<>();

    public CommonEvents() {
        TickEvent.PLAYER_POST.register(this::onPlayerTick);
        EntityEvent.LIVING_HURT.register(this::onLivingDamage);
    }

    public EventResult onLivingDamage(LivingEntity entity, DamageSource source, float amount) {
        if (hasUltranArmor(entity)) {
            return EventResult.interruptTrue();
        }
        return EventResult.pass();
    }

    private static boolean hasUltranArmor(LivingEntity entity) {
        Iterable<ItemStack> armorSlots = entity.getArmorSlots();
        boolean hasUltranArmor = true;
        for (ItemStack stack : armorSlots) {
            hasUltranArmor &= stack.getItem() instanceof UltranArmorBase;
        }
        return hasUltranArmor;
    }

    public void onPlayerTick(Player player) {
        if (hasUltranArmor(player)) {
            player.setAbsorptionAmount(80f);
            boolean mayfly = player.getAbilities().mayfly;
            if (!mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
            flyables.add(player);
        } else {
            if (!player.isCreative() && !player.isSpectator()) {
                boolean mayfly = player.getAbilities().mayfly;
                if (mayfly) {
                    player.getAbilities().mayfly = false;
                    player.getAbilities().flying = false;
                    player.onUpdateAbilities();
                }
            }
            flyables.remove(player);
        }
    }
}
