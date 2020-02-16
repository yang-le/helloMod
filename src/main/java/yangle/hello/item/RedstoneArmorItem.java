package yangle.hello.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;

public class RedstoneArmorItem extends ArmorItem {
    public RedstoneArmorItem(EquipmentSlotType slot) {
        super(ArmorMaterial.REDSTONE, slot, new Properties().group(ItemGroup.COMBAT));
    }

    public static class Helmet extends RedstoneArmorItem {
        public Helmet() {
            super(EquipmentSlotType.HEAD);
            setRegistryName("redstone_helmet");
        }
    }

    public static class Chestplate extends RedstoneArmorItem {
        public Chestplate() {
            super(EquipmentSlotType.CHEST);
            setRegistryName("redstone_chestplate");
        }
    }

    public static class Leggings extends RedstoneArmorItem {
        public Leggings() {
            super(EquipmentSlotType.LEGS);
            setRegistryName("redstone_leggings");
        }
    }

    public static class Boots extends RedstoneArmorItem {
        public Boots() {
            super(EquipmentSlotType.FEET);
            setRegistryName("redstone_boots");
        }
    }
}
