package q4niel.primitive;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;
import q4niel.primitive.mixin_interfaces.IEntityMixin;

import java.util.HashMap;
import java.util.UUID;

public class PlayerEntityPersistentData {
    static final int minMaxHealth = 6;
    static final int maxMaxHealth = 20;
    static HashMap<UUID, Integer> maxHealths = new HashMap<>();

    public static void OnSpawn(ServerPlayerEntity player) {
        int hp = maxHealths.getOrDefault(player.getUuid(), 0);
        SetMaxHealth(player, hp == 0 ? GetMaxHealth(player) : hp);
    }

    public static int GetMaxHealth(ServerPlayerEntity player) {
        int hp = ((IEntityMixin)player).GetPersistentNbt().getInt("max_health");
        maxHealths.put(player.getUuid(), (hp == 0 ? minMaxHealth : hp));
        return maxHealths.get(player.getUuid());
    }

    public static void SetMaxHealth(ServerPlayerEntity player, int value) {
        maxHealths.put(player.getUuid(), Math.clamp(value, minMaxHealth, maxMaxHealth));
        ((IEntityMixin)player).GetPersistentNbt().putInt("max_health", maxHealths.get(player.getUuid()));
        player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(maxHealths.get(player.getUuid()));
    }

    public static void IncrementMaxHealth(ServerPlayerEntity player, int value) {
        SetMaxHealth(player, GetMaxHealth(player) + value);
    }

    public static void DecrementMaxHealth(ServerPlayerEntity player, int value) {
        SetMaxHealth(player, GetMaxHealth(player) - value);
    }
}