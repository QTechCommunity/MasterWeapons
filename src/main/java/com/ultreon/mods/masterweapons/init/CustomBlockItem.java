package com.ultreon.mods.masterweapons.init;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/**
 * A block item that requires a supplier as parameter.
 *
 * @author Qboi123, Forge Team
 */
@SuppressWarnings("unused")
public class CustomBlockItem extends BlockItem {
    private final Supplier<Block> block;

    @SuppressWarnings("ConstantConditions")
    public CustomBlockItem(Supplier<Block> blockIn, Item.Properties builder) {
        super(null, builder);
        this.block = blockIn;
    }

    @SuppressWarnings("ConstantConditions")
    public Block getBlock() {
        return this.getBlockRaw() == null ? null : this.getBlockRaw().delegate.get();
    }

    private Block getBlockRaw() {
        return this.block.get();
    }
}
