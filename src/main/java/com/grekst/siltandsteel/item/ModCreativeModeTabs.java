package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import com.grekst.siltandsteel.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SiltAndSteel.MODID);

    public static final Supplier<CreativeModeTab> NATURE_TAB = CREATIVE_MODE_TAB.register("nature_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PEAT_CLUMP.get()))
                    .title(Component.translatable("creativetab.siltandsteel.nature"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PEAT_CLUMP);
                        output.accept(ModItems.DRIED_PEAT_CLUMP);

                        output.accept(ModBlocks.PEAT);

                    }).build());

    public static final Supplier<CreativeModeTab> PROGRESS_TAB = CREATIVE_MODE_TAB.register("progress_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_CHISEL.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SiltAndSteel.MODID, "nature_tab"))
                    .title(Component.translatable("creativetab.siltandsteel.progress"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_CHISEL);

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
