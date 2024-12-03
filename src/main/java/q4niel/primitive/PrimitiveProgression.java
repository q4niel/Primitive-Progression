package q4niel.primitive;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q4niel.primitive.block.ModBlocks;
import q4niel.primitive.item.ModItems;
import q4niel.primitive.worldgen.ModWorldGen;

public class PrimitiveProgression implements ModInitializer {
	public static final String MOD_ID = "primitive";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer SERVER;

	@Override
	public void onInitialize() {
		ModItems.Init();
		ModBlocks.Init();
		ModWorldGen.Init();

		ServerPlayConnectionEvents.JOIN.register (
				(handler, sender, server) -> {
					SERVER = server;
					PlayerEntityData.Init(handler.getPlayer());
				}
		);
	}
}