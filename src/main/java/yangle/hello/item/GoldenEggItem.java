package yangle.hello.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GoldenEggItem extends Item {
    public GoldenEggItem() {
        super(new Item.Properties().group(ItemGroup.MATERIALS));
        setRegistryName("golden_egg");
    }
}
