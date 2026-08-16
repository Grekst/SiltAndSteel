package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import com.grekst.siltandsteel.item.custom.ChiselItem;
import com.grekst.siltandsteel.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiltAndSteel.MODID);

    public static final DeferredItem<Item> PEAT_CLUMP = ITEMS.register("peat_clump",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> DRIED_PEAT_CLUMP = ITEMS.register("dried_peat_clump",
            () -> new FuelItem(new Item.Properties(), 400));


    public static final DeferredItem<Item> COPPER_CHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(new Item.Properties().durability(128)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


