package yangle.hello.event;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yangle.hello.enchantment.Enchantments;
import yangle.hello.recipe.Recipes;

@Mod.EventBusSubscriber
public class BlockEvents {
    static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onBlockHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        LOGGER.info("onBlockHarvestDrops");
        IWorld world = event.getWorld();
        if (world.isRemote())
            return;

        PlayerEntity player = event.getHarvester();
        if (player == null) // explosion or sth.
            return;

        ItemStack itemStack = player.getHeldItemMainhand();
        LOGGER.info("itemStack" + itemStack);
        if (itemStack.getItem() == Items.SHEARS
                || EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_BURN, itemStack) <= 0)
            return;

        Collection<IRecipe<?>> furnaceRecipes = Recipes.getRecipes((recipe) -> {
            return recipe instanceof FurnaceRecipe;
        });

        LOGGER.info("furnace recipes" + furnaceRecipes);
        List<ItemStack> drops = event.getDrops();
        for (int i = 0; i < drops.size(); ++i) {
            ItemStack dropStack = drops.get(i);
            Optional<IRecipe<?>> recipes = furnaceRecipes.stream().filter((recipe) -> {
                for (Ingredient input : recipe.getIngredients())
                    if (input.test(dropStack))
                        return true;

                return false;
            }).findAny();

            if (recipes.isPresent()) {
                LOGGER.info("recipe present");
                drops.set(i, recipes.get().getRecipeOutput());
            } else {
                Block block = Block.getBlockFromItem(dropStack.getItem());
                BlockPos pos = event.getPos();
                if (block.isFlammable(block.getDefaultState(), world, pos, Direction.DOWN)
                        || block.isFlammable(block.getDefaultState(), world, pos, Direction.UP)
                        || block.isFlammable(block.getDefaultState(), world, pos, Direction.SOUTH)
                        || block.isFlammable(block.getDefaultState(), world, pos, Direction.NORTH)
                        || block.isFlammable(block.getDefaultState(), world, pos, Direction.WEST)
                        || block.isFlammable(block.getDefaultState(), world, pos, Direction.EAST)) {
                    LOGGER.info("block flammable");
                    event.getDrops().remove(dropStack);
                }
            }
        }
    }
}
