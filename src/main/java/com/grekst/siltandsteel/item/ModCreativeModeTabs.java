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
                        output.accept(ModItems.DRIED_PEAT_CUBE);

                        output.accept(ModBlocks.PEAT);
                        output.accept(ModBlocks.SILT);
                        output.accept(ModBlocks.SILT_IRON_ORE);
                        output.accept(ModItems.BOG_IRON);
                        output.accept(ModItems.CARBON_POWDER);
                        output.accept(ModItems.SALTPETER_POWDER);
                        output.accept(ModItems.SULFUR);
                        output.accept(ModBlocks.NETHER_SULFUR_ORE);

                    }).build());

    public static final Supplier<CreativeModeTab> PROGRESS_TAB = CREATIVE_MODE_TAB.register("progress_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_CHISEL.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(SiltAndSteel.MODID, "nature_tab"))
                    .title(Component.translatable("creativetab.siltandsteel.progress"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_CHISEL);
                        output.accept(ModItems.COPPER_SHEARS);
                        output.accept(ModItems.MORTAR_AND_PESTLE);
                        output.accept(ModItems.BAG_OF_FERTILIZER);
                        output.accept(ModItems.LARGE_BAG_OF_FERTILIZER);

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
