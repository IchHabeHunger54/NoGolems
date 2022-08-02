package ihh.nogolems.mixin;

import ihh.nogolems.Config;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;
import javax.annotation.Nullable;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {
    @Shadow @Nullable private BlockPattern snowGolemBase;
    @Shadow @Nullable private BlockPattern snowGolemFull;
    @Shadow @Nullable private BlockPattern ironGolemBase;
    @Shadow @Nullable private BlockPattern ironGolemFull;
    private static final Supplier<BlockPattern> nullPattern = () -> BlockPatternBuilder.start().aisle("#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.VOID_AIR))).build();

    @Inject(method = "getOrCreateSnowGolemBase()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    public void getOrCreateSnowGolemBaseMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_SNOW_GOLEM.get()) {
            if (snowGolemBase != nullPattern.get())
                snowGolemBase = nullPattern.get();
        } else if (snowGolemBase == nullPattern.get()) snowGolemBase = null;
    }

    @Inject(method = "getOrCreateSnowGolemFull()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    public void getOrCreateSnowGolemFullMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_SNOW_GOLEM.get()) {
            if (snowGolemFull != nullPattern.get())
                snowGolemFull = nullPattern.get();
        } else if (snowGolemFull == nullPattern.get()) snowGolemFull = null;
    }

    @Inject(method = "getOrCreateIronGolemBase()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    public void getOrCreateIronGolemBaseMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_IRON_GOLEM.get()) {
            if (ironGolemBase != nullPattern.get())
                ironGolemBase = nullPattern.get();
        } else if (ironGolemBase == nullPattern.get()) ironGolemBase = null;
    }

    @Inject(method = "getOrCreateIronGolemFull()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    public void getOrCreateIronGolemFullMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_IRON_GOLEM.get()) {
            if (ironGolemFull != nullPattern.get())
                ironGolemFull = nullPattern.get();
        } else if (ironGolemFull == nullPattern.get()) ironGolemFull = null;
    }
}
