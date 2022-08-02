package ihh.nogolems.mixin;

import ihh.nogolems.Config;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WitherSkullBlock;
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

@Mixin(WitherSkullBlock.class)
public class WitherSkullBlockMixin {
    @Shadow @Nullable private static BlockPattern witherPatternBase;
    @Shadow @Nullable private static BlockPattern witherPatternFull;
    private static final Supplier<BlockPattern> nullPattern = () -> BlockPatternBuilder.start().aisle("#").where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.VOID_AIR))).build();

    @Inject(method = "getOrCreateWitherBase()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    private static void getOrCreateWitherBaseMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_WITHER.get()) {
            if (witherPatternBase != nullPattern.get())
                witherPatternBase = nullPattern.get();
        } else if (witherPatternBase == nullPattern.get()) witherPatternBase = null;
    }

    @Inject(method = "getOrCreateWitherFull()Lnet/minecraft/world/level/block/state/pattern/BlockPattern;", at = @At("HEAD"))
    private static void getOrCreateWitherFullMixin(CallbackInfoReturnable<BlockPattern> callback) {
        if (Config.DISABLE_WITHER.get()) {
            if (witherPatternFull != nullPattern.get())
                witherPatternFull = nullPattern.get();
        } else if (witherPatternFull == nullPattern.get()) witherPatternFull = null;
    }
}
