package yangle.hello;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.registries.ObjectHolder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

import yangle.hello.item.*;
import yangle.hello.block.*;
import yangle.hello.config.*;
import yangle.hello.sound.SoundEvents;

@Mod(Hello.MOD_ID)
public class Hello {
    private static final Logger LOGGER = LogManager.getLogger();

    static final String MOD_ID = "hello";

    @ObjectHolder("hello:grass_block")
    public static final Block grass_block = null;

    public Hello() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HelloConfig.spec);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            LOGGER.info("registerItems");
            event.getRegistry().registerAll(new GoldenEggItem(), new GrassBlockItem(grass_block),
                    new RedstonePickaxeItem(), new RedstoneAppleItem(), new RedstoneArmorItem.Helmet(),
                    new RedstoneArmorItem.Chestplate(), new RedstoneArmorItem.Leggings(),
                    new RedstoneArmorItem.Boots());
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            LOGGER.info("registerBlocks");
            event.getRegistry().register(new GrassBlock());
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class LifecycleEvents {
        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event) {
            LOGGER.info("commonSetup");
        }

        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            LOGGER.info("clientSetup");
        }

        @SubscribeEvent
        public static void interModEnqueue(InterModEnqueueEvent event) {
            LOGGER.info("interModEnqueue");
        }

        @SubscribeEvent
        public static void interModPorcess(InterModProcessEvent event) {
            LOGGER.info("interModPorcess");
        }
    }

    @Mod.EventBusSubscriber
    public static class PlayerEvents {
        @SubscribeEvent
        public static void onPlayerItemCrafted(PlayerEvent.ItemCraftedEvent event) {
            event.getPlayer().playSound(SoundEvents.TEST, 1.0F, 1.0F);
            // if (event.crafting.getItem() ==
            // Item.getItemFromBlock(BlockLoader.grassBlock))
            // {
            // event.player.triggerAchievement(AchievementLoader.buildGrassBlock);
            // }
        }
    }
}
