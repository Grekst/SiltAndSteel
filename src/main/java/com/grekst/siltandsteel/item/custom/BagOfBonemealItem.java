package com.grekst.siltandsteel.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.event.ActionEvent;

public class BagOfBonemealItem extends Item {
    public BagOfBonemealItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();

        if (block instanceof BonemealableBlock bonemealable
                && bonemealable.isValidBonemealTarget(level, pos, state)) {

            if (level instanceof ServerLevel serverLevel) {
                if (bonemealable.isBonemealSuccess(level, level.random, pos, state)) {
                    bonemealable.performBonemeal(serverLevel, level.random, pos, state);
                }

                Player player = context.getPlayer();
                ItemStack stack = context.getItemInHand();
                ServerPlayer serverPlayer = player instanceof ServerPlayer sp ? sp : null;

                stack.hurtAndBreak(1, serverLevel, serverPlayer,
                        item -> stack.setCount(0));

                level.levelEvent(1505, pos, 0);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
