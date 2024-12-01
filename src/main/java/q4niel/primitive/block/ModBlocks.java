package q4niel.primitive.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import q4niel.primitive.PrimitiveProgression;

public class ModBlocks {
    public static final Block SOUL_ORE = newBlock (
            "soul_ore",
            new ExperienceDroppingBlock(
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                            .strength(30, 1200)
            )
    );

    public static void Init() {
        addToItemGroup(ItemGroups.NATURAL, new Block[] {
                SOUL_ORE
        });
    }

    static Block newBlock(String id, Block block) {
        Registry.register (
                Registries.ITEM,
                Identifier.of(PrimitiveProgression.MOD_ID, id),
                new BlockItem(block, new Item.Settings())
        );

        return Registry.register (
                Registries.BLOCK,
                Identifier.of(PrimitiveProgression.MOD_ID, id),
                block
        );
    }

    static void addToItemGroup(RegistryKey<ItemGroup> group, Block[] blocks) {
        ItemGroupEvents.modifyEntriesEvent(group).register (
                entries -> {
                    for (Block block : blocks) {
                        entries.add(block);
                    }
                }
        );
    }
}