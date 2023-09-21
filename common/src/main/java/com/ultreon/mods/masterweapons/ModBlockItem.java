package com.ultreon.mods.masterweapons;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

/**
 * A block item that requires a supplier as parameter.
 *
 * @author XyperCode, Forge Team
 */
@SuppressWarnings("unused")
public class ModBlockItem extends BlockItem {
    @Deprecated
    private final RegistrySupplier<? extends Block> block;

    @SuppressWarnings("ConstantConditions")
    public ModBlockItem(RegistrySupplier<? extends Block> blockIn, Properties builder) {
        super(null, builder);
        this.block = blockIn;
    }

    @NotNull
    public Block getBlock() {
        return this.getBlockRaw() == null ? Blocks.AIR : this.getBlockRaw();
    }

    private Block getBlockRaw() {
        return this.block.getOrNull();
    }
}
