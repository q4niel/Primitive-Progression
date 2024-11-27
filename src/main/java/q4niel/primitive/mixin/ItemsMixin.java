package q4niel.primitive.mixin;

import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import q4niel.primitive.PrimitiveToolMaterials;

@Mixin(Items.class)
public class ItemsMixin {
//Wood
    //Sword
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/SwordItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 0), index = 0)
    private static ToolMaterial woodSwordInit(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/SwordItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;IF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 0), index = 0)
    private static ToolMaterial woodSwordAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }
    //Shovel
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 0), index = 0)
    private static ToolMaterial woodShovelInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.FLINT; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 0), index = 0)
    private static ToolMaterial woodShovelAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }
    //Pickaxe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 0), index = 0)
    private static ToolMaterial woodPickaxeInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.FLINT; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 0), index = 0)
    private static ToolMaterial woodPickaxeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }
    //Axe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 0), index = 0)
    private static ToolMaterial woodAxeInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.FLINT; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 0), index = 0)
    private static ToolMaterial woodAxeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }
    //Hoe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 0), index = 0)
    private static ToolMaterial woodHoe(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.FLINT; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 0), index = 0)
    private static ToolMaterial woodHoeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.FLINT; }

//Stone
    //Sword
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/SwordItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 1), index = 0)
    private static ToolMaterial stoneSwordInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.COPPER; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/SwordItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;IF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 1), index = 0)
    private static ToolMaterial stoneSwordAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.COPPER; }
    //Shovel
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 1), index = 0)
    private static ToolMaterial stoneShovelInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.COPPER; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ShovelItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 1), index = 0)
    private static ToolMaterial stoneShovelAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.COPPER; }
    //Pickaxe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 1), index = 0)
    private static ToolMaterial stonePickaxeInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.COPPER; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/PickaxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 1), index = 0)
    private static ToolMaterial stonePickaxeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.COPPER; }
    //Axe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 1), index = 0)
    private static ToolMaterial stoneAxeInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.COPPER; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/AxeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 1), index = 0)
    private static ToolMaterial stoneAxeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.COPPER; }
    //Hoe
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V", ordinal = 1), index = 0)
    private static ToolMaterial stoneHoeInit(ToolMaterial toolMaterial) { return PrimitiveToolMaterials.COPPER; }
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/HoeItem;createAttributeModifiers(Lnet/minecraft/item/ToolMaterial;FF)Lnet/minecraft/component/type/AttributeModifiersComponent;", ordinal = 1), index = 0)
    private static ToolMaterial stoneHoeAttribute(ToolMaterial mat) { return PrimitiveToolMaterials.COPPER; }
}
