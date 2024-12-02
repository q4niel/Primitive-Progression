package q4niel.primitive.datagen.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import q4niel.primitive.PrimitiveProgression;
import q4niel.primitive.datagen.worldgen.ore.ModOrePlacement;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> LIFE_CRYSTAL_ORE_PLACED_KEY = registerKey("life_crystal_ore_placed");
    public static final RegistryKey<PlacedFeature> DEEPSLATE_LIFE_CRYSTAL_ORE_PLACED_KEY = registerKey("deepslate_life_crystal_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configFeats = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register (
                context,
                LIFE_CRYSTAL_ORE_PLACED_KEY,
                configFeats.getOrThrow(ModConfigFeatures.LIFE_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount (
                        50,
                        HeightRangePlacementModifier.trapezoid (
                                YOffset.fixed(-128),
                                YOffset.fixed(256)
                        )
                )
        );

        register (
                context,
                DEEPSLATE_LIFE_CRYSTAL_ORE_PLACED_KEY,
                configFeats.getOrThrow(ModConfigFeatures.DEEPSLATE_LIFE_CRYSTAL_ORE_KEY),
                ModOrePlacement.modifiersWithCount (
                        50,
                        HeightRangePlacementModifier.trapezoid (
                                YOffset.fixed(-128),
                                YOffset.fixed(256)
                        )
                )
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String id) {
        return RegistryKey.of (
                RegistryKeys.PLACED_FEATURE,
                Identifier.of(PrimitiveProgression.MOD_ID, id)
        );
    }

    static void register (
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> config,
            List<PlacementModifier> modifiers
    ) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    static <T extends FeatureConfig, U extends Feature<T>> void register (
            Registerable<PlacedFeature> context,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> config,
            PlacementModifier... modifiers
    ) {
        register(context, key, config, List.of(modifiers));
    }
}