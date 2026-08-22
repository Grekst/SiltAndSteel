package com.grekst.siltandsteel.item;

import com.grekst.siltandsteel.SiltAndSteel;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SiltAndSteel.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Creates a 3D crystal pillar using the 2D amethyst shard texture
        getBuilder("3d_amethyst_crystal")
                .parent(new ModelFile.UncheckedModelFile("minecraft:block/block"))
                .texture("0", mcLoc("item/amethyst_shard"))
                .texture("particle", mcLoc("item/amethyst_shard"))
                .element()
                .from(6, 0, 6)   // Start coordinates [x, y, z] from 0 to 16
                .to(10, 12, 10)  // End coordinates [x, y, z]
                .face(Direction.NORTH).texture("#0").uvs(0, 0, 16, 16).end()
                .face(Direction.SOUTH).texture("#0").uvs(0, 0, 16, 16).end()
                .face(Direction.EAST).texture("#0").uvs(0, 0, 16, 16).end()
                .face(Direction.WEST).texture("#0").uvs(0, 0, 16, 16).end()
                .face(Direction.UP).texture("#0").uvs(0, 0, 16, 16).end()
                .face(Direction.DOWN).texture("#0").uvs(0, 0, 16, 16).end()
                .end();
    }
}