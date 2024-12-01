package q4niel.primitive.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import q4niel.primitive.PrimitiveProgression;

public class ModItems {
    public static final Item SOUL_CRYSTAL = newItem("soul_crystal", new Item(new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));
    public static final Item LIFE_DRINK = newItem("life_drink", new LifeDrinkItem(32, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));

    public static void Init() {
        addToItemGroup(ItemGroups.INGREDIENTS, new Item[] {
                SOUL_CRYSTAL
        });

        addToItemGroup(ItemGroups.FOOD_AND_DRINK, new Item[] {
                LIFE_DRINK
        });
    }

    static Item newItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PrimitiveProgression.MOD_ID, id), item);
    }

    static void addToItemGroup(RegistryKey<ItemGroup> group, Item[] items) {
        ItemGroupEvents.modifyEntriesEvent(group).register (
                entries -> {
                    for (Item item : items) {
                        entries.add(item);
                    }
                }
        );
    }
}