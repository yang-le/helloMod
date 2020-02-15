package yangle.hello.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.crafting.Ingredient;

public class ItemRedstonePickaxe extends PickaxeItem
{
    public ItemRedstonePickaxe()
    {
        super(new ItemTier(3, 16, 16.0F, 0.0F, 10, () -> {
            return Ingredient.fromItems(Items.RED_SANDSTONE);
        }), 1, 1, new Properties()
            .group(ItemGroup.TOOLS)
        );
        setRegistryName("redstone_pickaxe");
    }
}
