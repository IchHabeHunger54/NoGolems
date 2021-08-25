package ihh.nogolems.mixin;

import ihh.nogolems.Config;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.CachedBlockInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Supplier;
import javax.annotation.Nullable;

@Mixin(CarvedPumpkinBlock.class)
public class CarvedPumpkinBlockMixin {
    @Shadow @Nullable private BlockPattern snowmanBasePattern;
    @Shadow @Nullable private BlockPattern snowmanPattern;
    @Shadow @Nullable private BlockPattern golemBasePattern;
    @Shadow @Nullable private BlockPattern golemPattern;
    private static final Supplier<BlockPattern> nullPattern = () -> BlockPatternBuilder.start().aisle("#").where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.VOID_AIR))).build();

    @Inject(method = "getSnowmanBasePattern()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    public void getSnowmanBasePatternMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_SNOW_GOLEM.get()) {
            if (snowmanBasePattern != nullPattern.get())
                snowmanBasePattern = nullPattern.get();
        } else if (snowmanBasePattern == nullPattern.get()) snowmanBasePattern = null;
    }

    @Inject(method = "getSnowmanPattern()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    public void getSnowmanPatternMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_SNOW_GOLEM.get()) {
            if (snowmanPattern != nullPattern.get())
                snowmanPattern = nullPattern.get();
        } else if (snowmanPattern == nullPattern.get()) snowmanPattern = null;
    }
    
    @Inject(method = "getGolemBasePattern()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    public void getGolemBasePatternMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_IRON_GOLEM.get()) {
            if (golemBasePattern != nullPattern.get())
                golemBasePattern = nullPattern.get();
        } else if (golemBasePattern == nullPattern.get()) golemBasePattern = null;
    }
    
    @Inject(method = "getGolemPattern()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    public void getGolemPatternMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_IRON_GOLEM.get()) {
            if (golemPattern != nullPattern.get())
                golemPattern = nullPattern.get();
        } else if (golemPattern == nullPattern.get()) golemPattern = null;
    }
}
