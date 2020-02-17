package yangle.hello;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import yangle.hello.config.HelloConfig;

@Mod(Hello.MOD_ID)
public class Hello {
    static final String MOD_ID = "hello";

    public Hello() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HelloConfig.spec);
    }
}
