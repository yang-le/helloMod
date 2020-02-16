package yangle.hello.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;

public class ItemRedstoneArmor extends ArmorItem {
    public ItemRedstoneArmor(EquipmentSlotType slot) {
        super(ArmorMaterial.REDSTONE, slot, new Properties().group(ItemGroup.COMBAT));
    }

    public static class Helmet extends ItemRedstoneArmor {
        public Helmet() {
            super(EquipmentSlotType.HEAD);
            setRegistryName("redstone_helmet");
        }
    }

    public static class Chestplate extends ItemRedstoneArmor {
        public Chestplate() {
            super(EquipmentSlotType.CHEST);
            setRegistryName("redstone_chestplate");
        }
    }

    public static class Leggings extends ItemRedstoneArmor {
        public Leggings() {
            super(EquipmentSlotType.LEGS);
            setRegistryName("redstone_leggings");
        }
    }

    public static class Boots extends ItemRedstoneArmor {
        public Boots() {
            super(EquipmentSlotType.FEET);
            setRegistryName("redstone_boots");
        }
    }
}
