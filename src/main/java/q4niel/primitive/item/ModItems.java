package q4niel.primitive.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
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
    public static final Item LIFE_CRYSTAL = newItem("life_crystal", new LifeCrystalItem(32, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));

    public static final Item COPPER_HELMET = newItem (
            "copper_helmet",
            new ArmorItem (
                    ModArmorMaterials.COPPER_ARMOR_MATERIAL,
                    ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
            )
    );

    public static final Item COPPER_CHESTPLATE = newItem (
            "copper_chestplate",
            new ArmorItem (
                    ModArmorMaterials.COPPER_ARMOR_MATERIAL,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
            )
    );

    public static final Item COPPER_LEGGINGS = newItem (
            "copper_leggings",
            new ArmorItem (
                    ModArmorMaterials.COPPER_ARMOR_MATERIAL,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
            )
    );

    public static final Item COPPER_BOOTS = newItem (
            "copper_boots",
            new ArmorItem (
                    ModArmorMaterials.COPPER_ARMOR_MATERIAL,
                    ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
            )
    );

    public static void Init() {
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, new Item[] {
                LIFE_CRYSTAL
        });

        addToItemGroup(ItemGroups.COMBAT, new Item[] {
                COPPER_HELMET,
                COPPER_CHESTPLATE,
                COPPER_LEGGINGS,
                COPPER_BOOTS
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