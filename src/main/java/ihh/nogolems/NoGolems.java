package ihh.nogolems;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(NoGolems.MOD_ID)
public class NoGolems {
    public static final String MOD_ID = "nogolems";

    public NoGolems() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }
}
