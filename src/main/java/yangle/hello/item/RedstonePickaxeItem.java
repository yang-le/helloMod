package yangle.hello.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class RedstonePickaxeItem extends PickaxeItem {
    public RedstonePickaxeItem() {
        super(ItemTier.REDSTONE, 1, 1, new Properties().group(ItemGroup.TOOLS));
        setRegistryName("redstone_pickaxe");
    }
}
