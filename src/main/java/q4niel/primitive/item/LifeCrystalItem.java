package q4niel.primitive.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import q4niel.primitive.PlayerEntityData;

public class LifeCrystalItem extends Item {
    public LifeCrystalItem(int maxUseTime, Settings settings) {
        super(settings);
        this.MAX_USE_TIME = maxUseTime;
    }

    final int MAX_USE_TIME;

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) { return MAX_USE_TIME; }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.EAT;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
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

        return stack;
    }
}