package yangle.hello.sound;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundEvents {
    private static final Logger LOGGER = LogManager.getLogger();

    @ObjectHolder("hello:test")
    public static final SoundEvent TEST = null;

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        LOGGER.info("registerSounds");
        event.getRegistry().registerAll(soundEvent("hello:test"));
    }

    private static SoundEvent soundEvent(String name) {
        return new SoundEvent(new ResourceLocation(name)).setRegistryName(name);
    }
}
