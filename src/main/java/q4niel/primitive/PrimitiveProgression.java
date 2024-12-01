package q4niel.primitive;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q4niel.primitive.block.ModBlocks;
import q4niel.primitive.item.ModItems;

public class PrimitiveProgression implements ModInitializer {
	public static final String MOD_ID = "primitive";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.Init();
		ModBlocks.Init();

		ServerPlayConnectionEvents.JOIN.register (
				(handler, sender, server) -> {
					ServerPlayerEntity player = handler.getPlayer();
					PlayerEntityData.Init(player);

					// Set the player's max health
					EntityAttributeInstance maxHealth = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
					if (maxHealth != null) {
						maxHealth.setBaseValue(PlayerEntityData.GetMaxHealth());
					}
				}
		);
	}
}