package q4niel.primitive.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import q4niel.primitive.PrimitiveProgression;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> COPPER_ARMOR_MATERIAL = register (
            "copper",
            () -> new ArmorMaterial (
                    Util.make (
                            new EnumMap<>(ArmorItem.Type.class),
                            map -> {
                                map.put(ArmorItem.Type.HELMET, 2);
                                map.put(ArmorItem.Type.CHESTPLATE, 6);
                                map.put(ArmorItem.Type.LEGGINGS, 4);
                                map.put(ArmorItem.Type.BOOTS, 2);
                                map.put(ArmorItem.Type.BODY, 4);
                            }
                    ),
                    20,
                    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
                    () -> Ingredient.ofItems(Items.COPPER_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(PrimitiveProgression.MOD_ID, "copper"))),
                    0,
                    0
            )
    );


    public static RegistryEntry<ArmorMaterial> register(String id, Supplier<ArmorMaterial> mat) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(PrimitiveProgression.MOD_ID, id), mat.get());
    }
}