package q4niel.primitive.worldgen.ore;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import q4niel.primitive.datagen.worldgen.ModPlacedFeatures;

public class ModOreGen {
    public static void Init() {
        BiomeModifications.addFeature (
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.LIFE_CRYSTAL_ORE_PLACED_KEY
        );
    }
}