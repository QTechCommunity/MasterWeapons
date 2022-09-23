package com.ultreon.mods.masterweapons;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * A block item that requires a supplier as parameter.
 *
 * @author Qboi123, Forge Team
 */
@Deprecated
@SuppressWarnings("unused")
public class ModBlockItem extends BlockItem {
    @Deprecated
    private final Supplier<Block> block;

    @SuppressWarnings("ConstantConditions")
    public ModBlockItem(Supplier<Block> blockIn, Properties builder) {
        super(null, builder);
        this.block = blockIn;
    }

    @NotNull
    public Block getBlock() {
        return this.getBlockRaw() == null ? Blocks.AIR : this.getBlockRaw().delegate.get();
    }

    private Block getBlockRaw() {
        return this.block.get();
    }
}
