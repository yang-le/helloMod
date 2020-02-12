package yangle.hello;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import yangle.hello.item.*;
import yangle.hello.block.*;

@Mod(Hello.MOD_ID)
public class Hello {
    static final String MOD_ID = "hello";
    
    @ObjectHolder("hello:grass_block")
    public static final Block grass_block = null;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                new ItemGoldenEgg(new Item.Properties()).setRegistryName("golden_egg"),
                new BlockItem(grass_block, new Item.Properties()) {
                    @Override
                    public int getBurnTime(ItemStack itemStack) {
                        return 100;
                    }
                }.setRegistryName(grass_block.getRegistryName())
            );
        }

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockGrassBlock(Block.Properties.create(Material.GOURD)).setRegistryName("grass_block"));
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