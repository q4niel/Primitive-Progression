package q4niel.primitive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import q4niel.primitive.block.ModBlockTags;
import q4niel.primitive.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) { super(output, registriesFuture); }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LIFE_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_LIFE_CRYSTAL_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LIFE_CRYSTAL_ORE)
                .add(ModBlocks.DEEPSLATE_LIFE_CRYSTAL_ORE)
        ;

        getOrCreateTagBuilder(ModBlockTags.INCORRECT_FOR_FLINT_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModBlockTags.NEEDS_COPPER_TOOL)
        ;

        getOrCreateTagBuilder(ModBlockTags.NEEDS_COPPER_TOOL)
                .add(Blocks.IRON_BLOCK)
                .add(Blocks.RAW_IRON_BLOCK)
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.LAPIS_BLOCK)
                .add(Blocks.LAPIS_ORE)
                .add(Blocks.DEEPSLATE_LAPIS_ORE)
                .add(Blocks.LIGHTNING_ROD)
                .add(Blocks.CRAFTER)
        ;
    }
}