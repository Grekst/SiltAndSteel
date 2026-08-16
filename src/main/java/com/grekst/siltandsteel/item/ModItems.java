package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import com.grekst.siltandsteel.item.custom.ChiselItem;
import com.grekst.siltandsteel.item.custom.FuelItem;
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
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext tooltipContext, List<Component> toolTipComponent, TooltipFlag toolTipFlag) {
                    toolTipComponent.add(Component.translatable("tooltip.siltandsteel.peat_clump.tooltip").withStyle(ChatFormatting.GRAY));

                    super.appendHoverText(stack, tooltipContext, toolTipComponent, toolTipFlag);
                }
            });

    public static final DeferredItem<Item> DRIED_PEAT_CUBE = ITEMS.register("dried_peat_cube",
            () -> new FuelItem(new Item.Properties(), 400));

    public static final DeferredItem<Item> BOG_IRON = ITEMS.register("bog_iron",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> COPPER_CHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(new Item.Properties().durability(128)));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}


