package q4niel.primitive.mixin;

import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import q4niel.primitive.PrimitiveToolMaterials;

@Mixin(Items.class)
public class ItemsMixin {
    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/SwordItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            ),
            index = 0
    )
    private static ToolMaterial woodSword(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.FLINT;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ShovelItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            ),
            index = 0
    )
    private static ToolMaterial woodShovel(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.FLINT;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/PickaxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            ),
            index = 0
    )
    private static ToolMaterial woodPickaxe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.FLINT;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/AxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            ),
            index = 0
    )
    private static ToolMaterial woodAxe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.FLINT;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 0
            ),
            index = 0
    )
    private static ToolMaterial woodHoe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.FLINT;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/SwordItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private static ToolMaterial stoneSword(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.COPPER;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ShovelItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private static ToolMaterial stoneShovel(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.COPPER;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/PickaxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private static ToolMaterial stonePickaxe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.COPPER;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/AxeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private static ToolMaterial stoneAxe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.COPPER;
    }

    @ModifyArg (
            method = "<clinit>",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/HoeItem;<init>(Lnet/minecraft/item/ToolMaterial;Lnet/minecraft/item/Item$Settings;)V",
                    ordinal = 1
            ),
            index = 0
    )
    private static ToolMaterial stoneHoe(ToolMaterial toolMaterial) {
        return PrimitiveToolMaterials.COPPER;
    }
}
