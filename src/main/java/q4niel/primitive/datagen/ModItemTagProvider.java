package q4niel.primitive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import q4niel.primitive.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) { super(output, completableFuture); }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        trimmableArmorSet(ModItems.COPPER_ARMOR_SET);
    }

    void trimmableArmorSet(ModItems.ArmorSet set) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(set.GET_HELMET())
                .add(set.GET_CHESTPLATE())
                .add(set.GET_LEGGINGS())
                .add(set.GET_BOOTS())
        ;
    }
}