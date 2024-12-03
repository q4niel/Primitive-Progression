package q4niel.primitive;

import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import q4niel.primitive.mixin_interfaces.IEntityMixin;

public class PlayerEntityData {
    static final String MAX_HEALTH = "max_health";
    static PlayerEntity player;
    static IEntityMixin entityMixin;
    static EntityAttributeInstance maxHealthAttribute;

    public static void Init(PlayerEntity player) {
        PlayerEntityData.player = player;
        PlayerEntityData.entityMixin = (IEntityMixin)player;
        PlayerEntityData.maxHealthAttribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);

        if (maxHealthAttribute == null) return;
        SetMaxHealth(GetMaxHealth() == 0 ? 6 : GetMaxHealth());
    }

    public static int GetMaxHealth() {
         return entityMixin.GetNbt().getInt(MAX_HEALTH);
    }

    public static void IncrementMaxHealth() { IncrementMaxHealth(1); }
    public static void IncrementMaxHealth(int amount) {
        SetMaxHealth(GetMaxHealth() + amount);
    }

    public static void DecrementMaxHealth() { DecrementMaxHealth(1); }
    public static void DecrementMaxHealth(int amount) {
        SetMaxHealth(GetMaxHealth() - amount);
    }

    public static void SetMaxHealth(int value) {
        PrimitiveProgression.SERVER.execute(() -> {
            final int clamped = Math.clamp(value, 6, 20);

            maxHealthAttribute.setBaseValue(clamped);
            entityMixin.GetNbt().putInt(MAX_HEALTH, clamped);
        });
    }
}