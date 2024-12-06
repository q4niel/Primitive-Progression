package q4niel.primitive;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import q4niel.primitive.mixin_interfaces.IEntityMixin;

public class PlayerEntityPersistentData {
    static int maxHealth = 0;

    public static void OnSpawn(ServerPlayerEntity player) {
        SetMaxHealth(player, maxHealth == 0 ? GetMaxHealth(player) : maxHealth);
    }


    public static int GetMaxHealth(ServerPlayerEntity player) {
        int hp = ((IEntityMixin)player).GetPersistentNbt().getInt("max_health");
        maxHealth = (hp == 0 ? 6 : hp);
        return maxHealth;
    }

    public static void IncrementMaxHealth(ServerPlayerEntity player, int value) {
        SetMaxHealth(player, GetMaxHealth(player) + value);
    }

    public static void DecrementMaxHealth(ServerPlayerEntity player, int value) {
        SetMaxHealth(player, GetMaxHealth(player) - value);
    }

    public static void SetMaxHealth(ServerPlayerEntity player, int value) {
        maxHealth = Math.clamp(value, 6, 20);
        ((IEntityMixin)player).GetPersistentNbt().putInt("max_health", maxHealth);
        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    }
}