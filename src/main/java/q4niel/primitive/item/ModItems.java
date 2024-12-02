package q4niel.primitive.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import q4niel.primitive.PrimitiveProgression;

public class ModItems {
    public static final Item LIFE_CRYSTAL = newItem("life_crystal", new LifeCrystalItem(32, new Item.Settings().maxCount(1).rarity(Rarity.EPIC)));
    public static final ArmorSet COPPER_ARMOR_SET = new ArmorSet("copper", ModArmorMaterials.COPPER_ARMOR_MATERIAL, 9);

    public static void Init() {
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, new Item[] {
                LIFE_CRYSTAL
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

    public static class ArmorSet {
        public final Item GET_HELMET() { return HELMET; }
        public final Item GET_CHESTPLATE() { return CHESTPLATE; }
        public final Item GET_LEGGINGS() { return LEGGINGS; }
        public final Item GET_BOOTS() { return BOOTS; }
        
        Item HELMET;
        Item CHESTPLATE;
        Item LEGGINGS;
        Item BOOTS;

        public ArmorSet(String idPrefix, RegistryEntry<ArmorMaterial> mat, int maxDmg) {
            HELMET = newItem(idPrefix + "_helmet", new ArmorItem(mat, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(maxDmg))));
            CHESTPLATE = newItem (idPrefix + "_chestplate", new ArmorItem(mat, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(maxDmg))));
            LEGGINGS = newItem(idPrefix + "_leggings", new ArmorItem(mat, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(maxDmg))));
            BOOTS = newItem(idPrefix + "_boots", new ArmorItem(mat, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(maxDmg))));

            addToItemGroup(ItemGroups.COMBAT, new Item[] {
                    HELMET,
                    CHESTPLATE,
                    LEGGINGS,
                    BOOTS
            });
        }
    }
}