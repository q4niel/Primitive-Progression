package q4niel.primitive.item;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import java.util.function.Supplier;
import net.minecraft.item.ToolMaterials;

public enum ModToolMaterials implements ToolMaterial {
    FLINT (
            ToolMaterials.WOOD.getInverseTag(),
            ToolMaterials.WOOD.getDurability(),
            ToolMaterials.WOOD.getMiningSpeedMultiplier(),
            ToolMaterials.WOOD.getAttackDamage(),
            ToolMaterials.WOOD.getEnchantability(),
            () -> Ingredient.ofItems(Items.FLINT)
    ),
    COPPER (
            ToolMaterials.STONE.getInverseTag(),
            ToolMaterials.STONE.getDurability(),
            ToolMaterials.STONE.getMiningSpeedMultiplier(),
            ToolMaterials.STONE.getAttackDamage(),
            ToolMaterials.STONE.getEnchantability(),
            () -> Ingredient.ofItems(Items.COPPER_INGOT)
    )
;

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    ) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }
    @Override public int getDurability() {
        return this.itemDurability;
    }
    @Override public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }
    @Override public float getAttackDamage() {
        return this.attackDamage;
    }
    @Override public int getEnchantability() {
        return this.enchantability;
    }
    @Override public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}