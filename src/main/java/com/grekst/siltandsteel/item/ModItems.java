package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SiltAndSteel.MODID);

    public static final DeferredItem<Item> PEAT_CLUMP = ITEMS.register("peat_clump",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


