package q4niel.primitive.mixin;

import net.minecraft.entity.Entity;
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
    NbtCompound persistentNbt;
    final String persistentNbtKey = PrimitiveProgression.MOD_ID + ":persistent_nbt";

    @Override
    public NbtCompound GetPersistentNbt() {
        if (persistentNbt == null) {
            persistentNbt = new NbtCompound();
        }
        return persistentNbt;
    }

    @Inject (
            method = "writeNbt(Lnet/minecraft/nbt/NbtCompound;)Lnet/minecraft/nbt/NbtCompound;",
            at = @At("HEAD")
    )
    void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (persistentNbt == null) return;
        nbt.put(persistentNbtKey, persistentNbt);
    }

    @Inject (
            method = "readNbt(Lnet/minecraft/nbt/NbtCompound;)V",
            at = @At("HEAD")
    )
    void readNbt(NbtCompound nbt, CallbackInfo ci) {
        if (!nbt.contains(persistentNbtKey)) return;
        persistentNbt = nbt.getCompound(persistentNbtKey);
    }
}