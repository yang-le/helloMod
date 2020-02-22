package yangle.hello.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class FireBurnEnchantment extends Enchantment {
    public FireBurnEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentType.DIGGER,
                new EquipmentSlotType[] { EquipmentSlotType.MAINHAND });
        setRegistryName("hello:fire_burn");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.SILK_TOUCH && ench != Enchantments.FORTUNE;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() == Items.SHEARS ? true : super.canApply(stack);
    }
}
