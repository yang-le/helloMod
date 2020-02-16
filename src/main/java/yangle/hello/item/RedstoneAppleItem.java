package yangle.hello.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;

public class RedstoneAppleItem extends Item {
    public RedstoneAppleItem() {
        super(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder().hunger(1).saturation(0.6F)
                .effect(new EffectInstance(Effects.ABSORPTION, 10, 1), 1.0F).setAlwaysEdible().build()));
        setRegistryName("redstone_apple");
    }
}
