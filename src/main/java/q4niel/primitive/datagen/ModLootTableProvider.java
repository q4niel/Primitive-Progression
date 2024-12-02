package q4niel.primitive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryWrapper;
import q4niel.primitive.block.ModBlocks;
import q4niel.primitive.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) { super(dataOutput, registryLookup); }

    @Override
    public void generate() {
        addNonFortuneOre(ModBlocks.LIFE_CRYSTAL_ORE, ModItems.LIFE_CRYSTAL);
    }

    void addNonFortuneOre(Block block, Item item) {
        addDrop (
                block,
                dropsWithSilkTouch (
                        block,
                        applyExplosionDecay(block, ItemEntry.builder(item))
                )
        );
    }
}