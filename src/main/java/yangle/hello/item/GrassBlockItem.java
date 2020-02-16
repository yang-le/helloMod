package yangle.hello.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class GrassBlockItem extends BlockItem {
    public GrassBlockItem(Block blockIn) {
        super(blockIn, new Properties());
        setRegistryName(blockIn.getRegistryName());
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 100;
    }
}
