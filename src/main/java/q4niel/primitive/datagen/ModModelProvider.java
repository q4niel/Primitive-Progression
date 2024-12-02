package q4niel.primitive.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import q4niel.primitive.PrimitiveProgression;
import q4niel.primitive.block.ModBlocks;
import q4niel.primitive.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LIFE_CRYSTAL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LIFE_CRYSTAL_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LIFE_CRYSTAL, Models.GENERATED);

        registerArmorSet(itemModelGenerator, ModItems.COPPER_ARMOR_SET);

        forceModTexture(itemModelGenerator, Items.WOODEN_PICKAXE, "flint_pickaxe", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.WOODEN_SHOVEL, "flint_shovel", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.WOODEN_AXE, "flint_axe", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.WOODEN_SWORD, "flint_sword", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.WOODEN_HOE, "flint_hoe", Models.HANDHELD);

        forceModTexture(itemModelGenerator, Items.STONE_PICKAXE, "copper_pickaxe", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.STONE_SHOVEL, "copper_shovel", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.STONE_AXE, "copper_axe", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.STONE_SWORD, "copper_sword", Models.HANDHELD);
        forceModTexture(itemModelGenerator, Items.STONE_HOE, "copper_hoe", Models.HANDHELD);
    }

    void forceModTexture(ItemModelGenerator itemModelGenerator, Item item, String texture, Model model) {
        model.upload (
                ModelIds.getItemModelId(item),
                new TextureMap().put (
                        TextureKey.LAYER0,
                        Identifier.of(PrimitiveProgression.MOD_ID, "item/" + texture)),
                itemModelGenerator.writer
        );
    }

    void registerArmorSet(ItemModelGenerator itemModelGenerator, ModItems.ArmorSet set) {
        itemModelGenerator.registerArmor((ArmorItem)set.GET_HELMET());
        itemModelGenerator.registerArmor((ArmorItem)set.GET_CHESTPLATE());
        itemModelGenerator.registerArmor((ArmorItem)set.GET_LEGGINGS());
        itemModelGenerator.registerArmor((ArmorItem)set.GET_BOOTS());
    }
}