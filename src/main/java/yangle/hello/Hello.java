package yangle.hello;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;

import yangle.hello.item.*;
import yangle.hello.block.*;
import yangle.hello.config.*;

@Mod(Hello.MOD_ID)
public class Hello {
    static final String MOD_ID = "hello";
    
    @ObjectHolder("hello:grass_block")
    public static final Block grass_block = null;

    public Hello() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HelloConfig.spec);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                new ItemGoldenEgg(),
                new ItemGrassBlock(grass_block),
                new ItemRedstonePickaxe()
            );
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockGrassBlock());
        }
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class LifecycleEvents {
        @SubscribeEvent
        public void commonSetup(final FMLCommonSetupEvent event) {
            
        }
    
        @SubscribeEvent
        public void clientSetup(final FMLClientSetupEvent event) {

        }
    
        @SubscribeEvent
        public void interModEnqueue(final InterModEnqueueEvent event) {
            
        }
    
        @SubscribeEvent
        public void interModPorcess(final InterModProcessEvent event) {
           
        }        
    }
}
