package yangle.hello.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import yangle.hello.block.*;
import yangle.hello.item.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    static final Logger LOGGER = LogManager.getLogger();

    @ObjectHolder("hello:grass_block")
    public static final Block grass_block = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        LOGGER.info("registerItems");
        event.getRegistry().registerAll(new GoldenEggItem(), new GrassBlockItem(grass_block), new RedstonePickaxeItem(),
                new RedstoneAppleItem(), new RedstoneArmorItem.Helmet(), new RedstoneArmorItem.Chestplate(),
                new RedstoneArmorItem.Leggings(), new RedstoneArmorItem.Boots());
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        LOGGER.info("registerBlocks");
        event.getRegistry().register(new GrassBlock());
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        LOGGER.info("registerSounds");
        event.getRegistry().registerAll(soundEvent("hello:test"));
    }

    private static SoundEvent soundEvent(String name) {
        return new SoundEvent(new ResourceLocation(name)).setRegistryName(name);
    }
}
