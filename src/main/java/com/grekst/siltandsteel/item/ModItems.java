package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import com.grekst.siltandsteel.item.custom.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiltAndSteel.MODID);

    public static final DeferredItem<Item> PEAT_CLUMP = ITEMS.register("peat_clump",
            () -> new Item(new Item.Properties()){
            });

    public static final DeferredItem<Item> DRIED_PEAT_CUBE = ITEMS.register("dried_peat_cube",
            () -> new FuelItem(new Item.Properties(), 400));

    public static final DeferredItem<Item> BOG_IRON = ITEMS.register("bog_iron",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SALTPETER_POWDER = ITEMS.register("saltpeter_powder",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CARBON_POWDER = ITEMS.register("carbon_powder",
            () -> new FuelItem(new Item.Properties(), 2000));

    public static final DeferredItem<Item> SULFUR = ITEMS.register("sulfur",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> COPPER_CHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(new Item.Properties().durability(128)));

    public static final DeferredItem<Item> MORTAR_AND_PESTLE = ITEMS.register("mortar_and_pestle",
            () -> new MortarAndPestleItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> COPPER_SHEARS = ITEMS.register("copper_shears",
            () -> new CopperShearsItem(new Item.Properties().durability(128)));

    public static final DeferredItem<Item> BAG_OF_FERTILIZER = ITEMS.register("bag_of_fertilizer",
            () -> new BagOfBonemealItem(new Item.Properties().durability(72)));

    public static final DeferredItem<Item> LARGE_BAG_OF_FERTILIZER = ITEMS.register("large_bag_of_fertilizer",
            () -> new BagOfBonemealItem(new Item.Properties().durability(576)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


