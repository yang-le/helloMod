package yangle.hello.recipe;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeManager;

public class Recipes {
    private static final Collection<IRecipe<?>> recipes = new RecipeManager().getRecipes();

    public static Collection<IRecipe<?>> getRecipes() {
        return recipes;
    }

    public static Collection<IRecipe<?>> getRecipes(Predicate<IRecipe<? extends IInventory>> predicate) {
        return recipes.stream().filter(predicate).collect(Collectors.toSet());
    }
}
