package q4niel.primitive;

import net.minecraft.entity.player.PlayerEntity;
import q4niel.primitive.mixin_interfaces.IEntityMixin;

public class PlayerEntityData {
    static final String MAX_HEALTH = "max_health";
    static IEntityMixin PLAYER;

    public static void Init(PlayerEntity player) {
        PLAYER = (IEntityMixin)player;
    }

    public static double GetMaxHealth() {
        double d = PLAYER.GetNbt().getDouble(MAX_HEALTH);
        return d == 0 ? 6 : d;
    }

    public static void SetMaxHealth(double value) {
        PLAYER.GetNbt().putDouble(MAX_HEALTH, value);
    }
}