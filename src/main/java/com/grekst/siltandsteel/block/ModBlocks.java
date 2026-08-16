package com.grekst.siltandsteel.block;

import com.grekst.siltandsteel.SiltAndSteel;
import com.grekst.siltandsteel.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(SiltAndSteel.MODID);

    public static final DeferredBlock<Block> PEAT = registerBlock("peat",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.7f)
                    .speedFactor(0.6f)
                    .sound(SoundType.GRAVEL)
            ));

    public static final DeferredBlock<Block> SILT = registerBlock("silt",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f)
                    .speedFactor(0.6f)
                    .sound(SoundType.GRAVEL)
            ));

    public static final DeferredBlock<Block> SILT_IRON_ORE = registerBlock("silt_iron_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8f)
                    .speedFactor(0.6f)
                    .sound(SoundType.GRAVEL)
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
