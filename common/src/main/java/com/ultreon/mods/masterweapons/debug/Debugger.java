package com.ultreon.mods.masterweapons.debug;

import com.ultreon.mods.masterweapons.init.ModBlocks;
import dev.architectury.platform.Platform;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;

public class Debugger {
    public static void onChunkLoad(LevelAccessor world, ChunkAccess chunk) {
        if (!Platform.isDevelopmentEnvironment()) {
            return;
        }

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = -64; y < 256; y++) {
                    ChunkPos chunkPos = chunk.getPos();

                    BlockPos blockPos = new BlockPos(x, y, z);
                    BlockState blockState = chunk.getBlockState(blockPos);
                    boolean isUltranOre = blockState.is(ModBlocks.ULTRAN_ORE.get()) || blockState.is(ModBlocks.DEEPSLATE_ULTRAN_ORE.get());

                    BlockPos exactCoords = blockPos.offset(chunkPos.x * 16, 0, chunkPos.z * 16);

                    if (isUltranOre) {
                        world.players().forEach(player -> player.sendSystemMessage(Component.empty()
                                .append(Component.literal("[DEBUG] ").withStyle(ChatFormatting.GOLD, ChatFormatting.BOLD))
                                .append(Component.literal("Ore located ").withStyle(ChatFormatting.WHITE))
                                .append(Component.literal("@").withStyle(ChatFormatting.GRAY))
                                .append(Component.literal(" " + exactCoords.toShortString()).withStyle(ChatFormatting.YELLOW))
                        ));
                    }
                }
            }
        }
    }
}
