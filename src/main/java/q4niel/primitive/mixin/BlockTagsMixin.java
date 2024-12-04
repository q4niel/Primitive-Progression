package q4niel.primitive.mixin;

import net.minecraft.registry.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockTags.class)
public class BlockTagsMixin {

    @ModifyArg (
            method = "<clinit>()V",
            at = @At (
                    value = "INVOKE",
                    target = "Lnet/minecraft/registry/tag/BlockTags;of(Ljava/lang/String;)Lnet/minecraft/registry/tag/TagKey;",
                    ordinal = 144
            ),
            index = 0
    )
    private static String modifyOfId(String id) {
        return "incorrect_for_iron_tool";
    }
}