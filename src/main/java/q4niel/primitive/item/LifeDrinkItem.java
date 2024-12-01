package q4niel.primitive.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import q4niel.primitive.PlayerEntityData;

public class LifeDrinkItem extends SoulDrinkItem {
    public LifeDrinkItem(int maxUseTime, Settings settings) { super(maxUseTime, settings); }

    @Override
    void FinishUsing(PlayerEntity player, ItemStack stack, World world, LivingEntity user) {
        EntityAttributeInstance attribute = player.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (attribute != null) {
            double maxHealth = attribute.getValue() + 2;
            attribute.setBaseValue(maxHealth);
            PlayerEntityData.SetMaxHealth(maxHealth);
        }

        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
    }
}