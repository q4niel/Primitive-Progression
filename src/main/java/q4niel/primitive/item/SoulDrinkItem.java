package q4niel.primitive.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public abstract class SoulDrinkItem extends Item {
    public SoulDrinkItem(int maxUseTime, Settings settings) {
        super(settings);
        this.MAX_USE_TIME = maxUseTime;
    }

    final int MAX_USE_TIME;

    abstract void FinishUsing(PlayerEntity player, ItemStack stack, World world, LivingEntity user);

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) { return MAX_USE_TIME; }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            FinishUsing(player, stack, world, user);
        }

        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }
}