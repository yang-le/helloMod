package yangle.hello.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class ItemRedstonePickaxe extends PickaxeItem
{
    public ItemRedstonePickaxe()
    {
        super(ItemTier.REDSTONE, 1, 1, new Properties()
            .group(ItemGroup.TOOLS)
        );
        setRegistryName("redstone_pickaxe");
    }
}
