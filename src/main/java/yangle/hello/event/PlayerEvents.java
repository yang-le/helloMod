package yangle.hello.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion.Mode;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerEvents {
    static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onPlayerItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        event.getPlayer().playSound(SoundEvents.TEST, 1.0F, 1.0F);
        // if (event.crafting.getItem() ==
        // Item.getItemFromBlock(BlockLoader.grassBlock))
        // {
        // event.player.triggerAchievement(AchievementLoader.buildGrassBlock);
        // }
    }

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        PlayerEntity player = event.getPlayer();
        if (player.isServerWorld() && event.getTarget() instanceof PigEntity) {
            PigEntity pig = (PigEntity) event.getTarget();
            Item item = event.getItemStack().getItem();
            if (item == Items.WHEAT || item == Items.WHEAT_SEEDS) {
                player.attackEntityFrom(new DamageSource("byPig").setDifficultyScaled().setExplosion(), 8.0F);
                Vec3d pigPos = pig.getPositionVec();
                event.getWorld().createExplosion(pig, pigPos.getX(), pigPos.getY(), pigPos.getZ(), 2.0F, false,
                        Mode.NONE);
                pig.onDeath(DamageSource.GENERIC);
            }
        }
    }
}
