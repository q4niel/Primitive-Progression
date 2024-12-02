package q4niel.primitive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }

    class Toolset {
        public final Item INGREDIENT;
        public final Item PICKAXE;
        public final Item SHOVEL;
        public final Item AXE;
        public final Item SWORD;
        public final Item HOE;

        public Toolset (
                Item ingredient,
                Item pickaxe,
                Item shovel,
                Item axe,
                Item sword,
                Item hoe
        ) {
            INGREDIENT = ingredient;
            PICKAXE = pickaxe;
            SHOVEL = shovel;
            AXE = axe;
            SWORD = sword;
            HOE = hoe;
        }
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.FLINT, 4)
                .input(Blocks.GRAVEL)
                .criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL))
                .offerTo(recipeExporter)
        ;

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.GRAVEL)
                .input('I', Items.FLINT)
                .pattern("II ")
                .pattern("II ")
                .pattern("   ")
                .criterion(hasItem(Items.FLINT), conditionsFromItem(Items.FLINT))
                .offerTo(recipeExporter)
        ;

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BUNDLE, 1)
                .input(Items.STRING)
                .input(Items.LEATHER)
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(recipeExporter)
        ;

        generateToolsets(recipeExporter, new Toolset[] {
                new Toolset(Items.FLINT, Items.WOODEN_PICKAXE, Items.WOODEN_SHOVEL, Items.WOODEN_AXE, Items.WOODEN_SWORD, Items.WOODEN_HOE),
                new Toolset(Items.COPPER_INGOT, Items.STONE_PICKAXE, Items.STONE_SHOVEL, Items.STONE_AXE, Items.STONE_SWORD, Items.STONE_HOE)
        });
    }

    void generateToolsets(RecipeExporter recipeExporter, Toolset[] toolsets) {
        for (Toolset set : toolsets) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, set.PICKAXE)
                    .input('I', set.INGREDIENT)
                    .input('S', Items.STICK)
                    .pattern("III")
                    .pattern(" S ")
                    .pattern(" S ")
                    .criterion(hasItem(set.INGREDIENT), conditionsFromItem(set.INGREDIENT))
                    .offerTo(recipeExporter)
            ;

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, set.SHOVEL)
                    .input('I', set.INGREDIENT)
                    .input('S', Items.STICK)
                    .pattern(" I ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .criterion(hasItem(set.INGREDIENT), conditionsFromItem(set.INGREDIENT))
                    .offerTo(recipeExporter)
            ;

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, set.AXE)
                    .input('I', set.INGREDIENT)
                    .input('S', Items.STICK)
                    .pattern("II ")
                    .pattern("IS ")
                    .pattern(" S ")
                    .criterion(hasItem(set.INGREDIENT), conditionsFromItem(set.INGREDIENT))
                    .offerTo(recipeExporter)
            ;

            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, set.SWORD)
                    .input('I', set.INGREDIENT)
                    .input('S', Items.STICK)
                    .pattern(" I ")
                    .pattern(" I ")
                    .pattern(" S ")
                    .criterion(hasItem(set.INGREDIENT), conditionsFromItem(set.INGREDIENT))
                    .offerTo(recipeExporter)
            ;

            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, set.HOE)
                    .input('I', set.INGREDIENT)
                    .input('S', Items.STICK)
                    .pattern("II ")
                    .pattern(" S ")
                    .pattern(" S ")
                    .criterion(hasItem(set.INGREDIENT), conditionsFromItem(set.INGREDIENT))
                    .offerTo(recipeExporter)
            ;
        }
    }
}