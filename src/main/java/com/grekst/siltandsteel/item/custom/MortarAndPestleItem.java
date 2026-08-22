package com.grekst.siltandsteel.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MortarAndPestleItem extends Item {

    public MortarAndPestleItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack copy = itemStack.copy();
        int newDamage = copy.getDamageValue() + 1;

        if (newDamage >= copy.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        copy.setDamageValue(newDamage);
        return copy;
    }
}