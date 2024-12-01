package q4niel.primitive.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import q4niel.primitive.PrimitiveProgression;

public class Items {
    public static final Item LIFE_DRINK = newItem("life_drink", new LifeDrinkItem(32, new Item.Settings().maxCount(1)));

    public static void Init() {
        addToGroup(ItemGroups.FOOD_AND_DRINK, new Item[] {
                LIFE_DRINK
        });
    }

    private static Item newItem(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PrimitiveProgression.MOD_ID, id), item);
    }

    private static void addToGroup(RegistryKey<ItemGroup> group, Item[] items) {
        ItemGroupEvents.modifyEntriesEvent(group).register (
                entries -> {
                    for (Item item : items) {
                        entries.add(item);
                    }
                }
        );
    }
}