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
import net.minecraft.util.Rarity;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import q4niel.primitive.PrimitiveProgression;

public class ModBlocks {
    public static final Block LIFE_CRYSTAL_ORE = newBlock (
            "life_crystal_ore",
            new Item.Settings().rarity(Rarity.EPIC),
            new ExperienceDroppingBlock (
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD)
                            .strength(30, 1200)
            )
    );

    public static final Block DEEPSLATE_LIFE_CRYSTAL_ORE = newBlock (
            "deepslate_life_crystal_ore",
            new Item.Settings().rarity(Rarity.EPIC),
            new ExperienceDroppingBlock (
                    UniformIntProvider.create(3, 7),
                    AbstractBlock.Settings.create()
                            .requiresTool()
                            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD)
                            .strength(50, 1200)
            )
    );

    public static void Init() {
        addToItemGroup(ItemGroups.NATURAL, new Block[] {
                LIFE_CRYSTAL_ORE,
                DEEPSLATE_LIFE_CRYSTAL_ORE
        });
    }

    static Block newBlock(String id, Item.Settings itemSettings, Block block) {
        Registry.register (
                Registries.ITEM,
                Identifier.of(PrimitiveProgression.MOD_ID, id),
                new BlockItem(block, itemSettings)
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