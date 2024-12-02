package q4niel.primitive.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import q4niel.primitive.PrimitiveProgression;
import q4niel.primitive.mixin_interfaces.IEntityMixin;

@Mixin(Entity.class)
public class EntityMixin implements IEntityMixin {
    NbtCompound nbt;

    @Override
    public NbtCompound GetNbt() {
        if (nbt == null) {
            nbt = new NbtCompound();
        }
        return nbt;
    }

    @Inject (
            method = "writeNbt(Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/nbt/NbtCompound;",
            at = @At("HEAD")
    )
    void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (((Entity)(Object)this) instanceof PlayerEntity) {
            if (nbt == null) return;
            nbt.put(PrimitiveProgression.MOD_ID, this.nbt);
        }
    }

    @Inject (
            method = "readNbt(Lnet/minecraft/nbt/NbtCompound;)V",
            at = @At("HEAD")
    )
    void readNbt(NbtCompound nbt, CallbackInfo ci) {
        if (((Entity)(Object)this) instanceof PlayerEntity) {
            if (!nbt.contains(PrimitiveProgression.MOD_ID)) return;
            this.nbt = nbt.getCompound(PrimitiveProgression.MOD_ID);
        }
    }
}