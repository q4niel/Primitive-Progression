package q4niel.primitive.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import q4niel.primitive.PlayerEntityData;

public class LifeCrystalItem extends Item {
    public LifeCrystalItem(Settings settings) { super(settings); }

    final int MAX_USE_TIME = 64;

    @Override
    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_STRIDER_EAT;
    }

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
                world.playSound (
                        player,
                        player.getTrackedPosition().getPos().x,
                        player.getTrackedPosition().getPos().y,
                        player.getTrackedPosition().getPos().z,
                        SoundEvents.ENTITY_PLAYER_BURP,
                        SoundCategory.PLAYERS,
                        1.5f,
                        1
                );
            }

            if (!player.getAbilities().creativeMode) {
                stack.decrement(1);
            }
        }

        return stack;
    }
}