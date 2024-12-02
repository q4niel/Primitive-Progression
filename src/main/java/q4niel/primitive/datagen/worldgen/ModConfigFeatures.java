package q4niel.primitive.datagen.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import q4niel.primitive.PrimitiveProgression;
import q4niel.primitive.block.ModBlocks;

import java.util.List;

public class ModConfigFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> LIFE_CRYSTAL_ORE_KEY = registerKey("life_crystal_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stone = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworld = List.of (
                OreFeatureConfig.createTarget(stone, ModBlocks.LIFE_CRYSTAL_ORE.getDefaultState())
        );

        register(context, LIFE_CRYSTAL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld, 20));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String id) {
        return RegistryKey.of (
                RegistryKeys.CONFIGURED_FEATURE,
                Identifier.of(PrimitiveProgression.MOD_ID, id)
        );
    }

    static <T extends FeatureConfig, U extends Feature<T>> void register (
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            U feature,
            T config
    ) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}