package ihh.nogolems;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec SPEC;
    public static ForgeConfigSpec.BooleanValue DISABLE_IRON_GOLEM;
    public static ForgeConfigSpec.BooleanValue DISABLE_SNOW_GOLEM;
    public static ForgeConfigSpec.BooleanValue DISABLE_WITHER;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        DISABLE_IRON_GOLEM = builder.comment("Disables creation of iron golems.").define("disable_iron_golem", true);
        DISABLE_SNOW_GOLEM = builder.comment("Disables creation of snow golems.").define("disable_snow_golem", true);
        DISABLE_WITHER = builder.comment("Disables creation of withers.").define("disable_wither", true);
        SPEC = builder.build();
    }
}
