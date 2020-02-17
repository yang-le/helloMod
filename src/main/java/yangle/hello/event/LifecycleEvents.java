package yangle.hello.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LifecycleEvents {
    static final Logger LOGGER = LogManager.getLogger();

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
