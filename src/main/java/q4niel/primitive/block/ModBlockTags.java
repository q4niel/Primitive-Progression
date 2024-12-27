package q4niel.primitive.block;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> NEEDS_COPPER_TOOL = of("needs_copper_tool");
    public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = of("incorrect_for_flint_tool");

    private static TagKey<Block> of(String id) {
        return TagKey.of (
                RegistryKeys.BLOCK,
                Identifier.ofVanilla(id)
        );
    }
}