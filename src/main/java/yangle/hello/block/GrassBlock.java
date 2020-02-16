package yangle.hello.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GrassBlock extends Block {
    public GrassBlock() {
        super(Block.Properties.create(Material.GOURD));
        setRegistryName("grass_block");
    }
}
