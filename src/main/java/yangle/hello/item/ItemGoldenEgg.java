package yangle.hello.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemGoldenEgg extends Item {
    public ItemGoldenEgg() {
        super(new Item.Properties().group(ItemGroup.MATERIALS));
        setRegistryName("golden_egg");
    }
}
