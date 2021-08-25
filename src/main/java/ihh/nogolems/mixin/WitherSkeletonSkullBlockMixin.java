package ihh.nogolems.mixin;

import ihh.nogolems.Config;
import net.minecraft.block.Blocks;
import net.minecraft.block.WitherSkeletonSkullBlock;
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

@Mixin(WitherSkeletonSkullBlock.class)
public class WitherSkeletonSkullBlockMixin {
    @Shadow @Nullable private static BlockPattern witherPatternBase;
    @Shadow @Nullable private static BlockPattern witherPatternFull;
    private static final Supplier<BlockPattern> nullPattern = () -> BlockPatternBuilder.start().aisle("#").where('#', CachedBlockInfo.hasState(BlockStateMatcher.forBlock(Blocks.VOID_AIR))).build();

    @Inject(method = "getOrCreateWitherBase()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    private static void getOrCreateWitherBaseMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_WITHER.get()) {
            if (witherPatternBase != nullPattern.get())
                witherPatternBase = nullPattern.get();
        } else if (witherPatternBase == nullPattern.get()) witherPatternBase = null;
    }

    @Inject(method = "getOrCreateWitherFull()Lnet/minecraft/block/pattern/BlockPattern;", at = @At("HEAD"), cancellable = true)
    private static void getOrCreateWitherFullMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_WITHER.get()) {
            if (witherPatternFull != nullPattern.get())
                witherPatternFull = nullPattern.get();
        } else if (witherPatternFull == nullPattern.get()) witherPatternFull = null;
    }
}
